package com.example.masterwork.services;

import com.example.masterwork.entities.PrintPlan;
import com.example.masterwork.entities.PrintPlanDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrintPlanService {
    public PrintPlanDto save(PrintPlanDto planDto);

    List<PrintPlanDto> allData();

    PrintPlanDto findById(long id);

    PrintPlanDto update(PrintPlanDto plan, long printPlanId);

    void deleteById(long printPlanId);
}
