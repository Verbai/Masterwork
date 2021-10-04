package com.example.masterwork.services;

import com.example.masterwork.entities.*;
import com.example.masterwork.exceptions.ResourceNotFoundException;
import com.example.masterwork.repositories.FilamentRepository;
import com.example.masterwork.repositories.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrinterServiceImpl implements PrinterService {

    final PrinterRepository printerRepository;

    public PrinterServiceImpl(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

    @Autowired
    FilamentRepository filamentRepository;

    @Autowired
    PrintPlanService printPlanService;

    public PrinterDto save(PrinterDto printerDto) {
        Printer printer1 = createPrinterFromDto(printerDto);
        printerRepository.save(printer1);
        Printer saved = printerRepository.save(printer1);
        return createDtoFromPrinter(saved);
    }

    @Override
    public List<PrinterDto> allData() {

        return printerRepository.findAll().stream().map(this::createDtoFromPrinter).collect(Collectors.toList());

    }

    @Override
    public Printer findById(long id) {
        Optional<Printer> printer = printerRepository.findById(id);
        if (!printer.isPresent()) {
            throw new ResourceNotFoundException("There is no Printer with this ID!");
        } else {
            return printer.get();
        }
    }

    @Override
    public void deleteById(long printerId) {
        printerRepository.deleteById(printerId);
    }

    @Override
    public Printer update(Printer printer, long printerId) {
        Optional<Printer> printerById = printerRepository.findById(printerId);
        if (!printerById.isPresent()) {
            throw new ResourceNotFoundException("Printer not found by given ID!");
        } else if (!(printerById.get().getId().equals(printer.getId()))) {
            throw new ResourceNotFoundException("Given ID and given printers ID not match!");
        } else {
            return printerRepository.save(printer);
        }
    }

    public Printer createPrinterFromDto(PrinterDto printerDto) {
        List<PrintPlanDto> printPlans;
        String printPlanIds = printerDto.getPrintPlanIds();
        if (printPlanIds == null || printPlanIds.isEmpty()) {
            printPlans = new ArrayList<>();
        } else {
            printPlans = Arrays.stream(printerDto.getPrintPlanIds().split(" "))
                    .map(id -> printPlanService.findById(Long.parseLong(id)))
                    .collect(Collectors.toList());
        }

        return new Printer(
                printerDto.getId(),
                printerDto.getName(),
                printerDto.getPrinterType(),
                printerDto.getPrintSize(),
                printerDto.getAcceptedFilamentDiameter(),
                printerDto.getMaxTemperature(),
                printerDto.getOperationCostPerHour(),
                filamentRepository.findCompatibleFilaments(printerDto.getAcceptedFilamentDiameter())
        );
    }

    public PrinterDto createDtoFromPrinter(Printer printer) {
        String printPlanIds;
        printPlanIds =
                printer.getPlans()
                        .stream()
                        .map(plan -> plan.getProjectName().toString())
                        .collect(Collectors.joining(", "));

        List<Filament> compatibleFilaments = filamentRepository.findCompatibleFilaments(printer.getAcceptedFilamentDiameter());

        StringBuilder availableFilaments = new StringBuilder();

        for (Filament filament : compatibleFilaments) {
            availableFilaments.append(
                    filament.getProducer())
                    .append(" ")
                    .append(filament.getMaterial())
                    .append(" ")
                    .append(filament.getLength())
                    .append(" m")
                    .append(", ");
        }

        return new PrinterDto(
                printer.getId(),
                printer.getName(),
                printer.getPrinterType(),
                printer.getPrintSize(),
                printer.getAcceptedFilamentDiameter(),
                printer.getMaxTemperature(),
                printer.getOperationCostPerHour(),
                availableFilaments.toString(),
                printPlanIds
        );
    }

}
