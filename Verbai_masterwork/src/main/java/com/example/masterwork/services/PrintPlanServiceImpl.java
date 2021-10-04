package com.example.masterwork.services;

import com.example.masterwork.entities.PrintPlan;
import com.example.masterwork.entities.PrintPlanDto;
import com.example.masterwork.entities.Printer;
import com.example.masterwork.exceptions.ResourceNotFoundException;
import com.example.masterwork.repositories.PrintPlanRepository;
import com.example.masterwork.repositories.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrintPlanServiceImpl implements PrintPlanService {

    final
    PrintPlanRepository planRepository;

    public PrintPlanServiceImpl(PrintPlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Autowired
    PrinterRepository printerRepository;

    @Override
    public PrintPlanDto save(PrintPlanDto planDto) {
        PrintPlan save = planRepository.save(createPrintPlanFromDto(planDto));
        return createDtoFromPrintPlan(save);
    }

    @Override
    public List<PrintPlanDto> allData() {
        return planRepository.findAll().stream().map(this::createDtoFromPrintPlan).collect(Collectors.toList());
    }

    @Override
    public PrintPlanDto findById(long id) {

        Optional<PrintPlan> byId = planRepository.findById(id);

        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Invalid printer Id");
        } else {
            return createDtoFromPrintPlan(byId.get());
        }
    }

    @Override
    public PrintPlanDto update(PrintPlanDto plan, long printPlanId){
        Optional<PrintPlan> byId = planRepository.findById(printPlanId);
        if(byId.isPresent()){
            return save(plan);
        }else throw new ResourceNotFoundException("Printplan not found!");
    }

    @Override
    public void deleteById(long filamentId) {
        planRepository.deleteById(filamentId);
    }

    public PrintPlanDto createDtoFromPrintPlan(PrintPlan plan) {
        return new PrintPlanDto(
                plan.getId(),
                plan.getProjectName(),
                plan.getFilamentLength(),
                plan.getTime(),
                plan.getAllCosts(),
                plan.getPrintStatus(),
                plan.getFileName(),
                plan.getPrinter().getName()
        );
    }

    public PrintPlan createPrintPlanFromDto(PrintPlanDto planDto) {
        Optional<Printer> printerBYName = printerRepository.findPrinterBYName(planDto.getPrinterName());
        if(printerBYName.isPresent()) {
            PrintPlan printPlan = new PrintPlan(
                    planDto.getId(),
                    planDto.getProjectName(),
                    planDto.getFilamentLength(),
                    planDto.getTime(),
                    planDto.getAllCosts(),
                    planDto.getPrintStatus(),
                    planDto.getPrintStatus(),
                    printerBYName.get()
            );
            return printPlan;
        }
        else throw new ResourceNotFoundException("There is no printer with this name!");
    }


}
