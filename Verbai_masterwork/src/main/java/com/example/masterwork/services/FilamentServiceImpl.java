package com.example.masterwork.services;

import com.example.masterwork.entities.Filament;
import com.example.masterwork.entities.FilamentDto;
import com.example.masterwork.entities.Printer;
import com.example.masterwork.entities.User;
import com.example.masterwork.exceptions.ResourceNotFoundException;
import com.example.masterwork.repositories.FilamentRepository;
import com.example.masterwork.repositories.PrinterRepository;
import com.example.masterwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilamentServiceImpl implements FilamentService {

    @Autowired
    private FilamentRepository filamentRepository;

    @Autowired
    private PrinterRepository printerRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public FilamentDto save(FilamentDto filamentDto) {
        Filament filament = filamentRepository.save(createFilamentFromFilamentDto(filamentDto));
        return createFilamentDtoFromFilament(filament);
    }

    public List<FilamentDto> allData() {
        return filamentRepository
                .findAll().stream()
                .map(this::createFilamentDtoFromFilament)
                .collect(Collectors.toList());
    }

    @Override
    public FilamentDto findById(Long filamentId) {
        Optional<Filament> result = filamentRepository.findById(filamentId);
        if (result.isPresent()) {
            return createFilamentDtoFromFilament(result.get());
        } else {
            throw new ResourceNotFoundException("There is no filament with such ID!");
        }
    }

    public List<FilamentDto> findByMaterialName(String material) {
        List<FilamentDto> collect = filamentRepository.findWhereMaterial(material).stream().map(this::createFilamentDtoFromFilament).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<FilamentDto> listAllFilamentWithRightWeight(Double weight) {
        List<FilamentDto> filamentList = filamentRepository.listAllFilamentWithRightWheight(weight).stream().map(this::createFilamentDtoFromFilament).collect(Collectors.toList());
        return filamentList;
    }


    private Filament createFilamentFromFilamentDto(FilamentDto filamentDto) {
        Optional<User> user = userRepository.findById(filamentDto.getUserId());

        if(user.isPresent()) {
            Filament filament = new Filament(
                    filamentDto.getId(),
                    filamentDto.getWeight(),
                    filamentDto.getLength(),
                    filamentDto.getDensity(),
                    filamentDto.getPrice(),
                    filamentDto.getDiameter(),
                    filamentDto.getProducer(),
                    filamentDto.getMaterial(),
                    user.get()
            );
            return filament;
        } else throw new ResourceNotFoundException("Invalid UserID given!");
    }

    private FilamentDto createFilamentDtoFromFilament(Filament filament) {
        List<Printer> compatibleFilaments = printerRepository.findCompatiblePrinter(filament.getDiameter());
        StringBuilder printers = new StringBuilder();
        for (Printer printer : compatibleFilaments) {
            printers.append(printer.getName()).append(", ");
        }

        FilamentDto filamentDto = new FilamentDto(
                filament.getId(),
                filament.getWeight(),
                filament.getLength(),
                filament.getDensity(),
                filament.getPrice(),
                filament.getDiameter(),
                filament.getProducer(),
                filament.getMaterial(),
                printers.toString(),
                filament.getUser().getId()
                );
        return filamentDto;
    }

    @Override
    public FilamentDto update(long filamentId, FilamentDto filamentDto) {
        Optional<Filament> filamentById = filamentRepository.findById(filamentId);
        System.out.println("Filament found!");
        if (!filamentById.isPresent()) {
            throw new ResourceNotFoundException("There is no Filament with this ID");
        } else if (!filamentById.get().getId().equals(filamentDto.getId())) {
            throw new ResourceNotFoundException("The path ID and the Filament ID are different!");
        } else {
            return save(filamentDto);
        }
    }

    @Override
    public void deleteById(long filamentId) {
        filamentRepository.deleteById(filamentId);
    }
}
