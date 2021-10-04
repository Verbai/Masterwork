package com.example.masterwork.controllers;

import com.example.masterwork.entities.PrintPlanDto;
import com.example.masterwork.services.PrintPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/printPlans")
public class PrintPlanController {

    final
    PrintPlanService printPlanService;

    public PrintPlanController(PrintPlanService printPlanService) {
        this.printPlanService = printPlanService;
    }

    @PostMapping
    public ResponseEntity<PrintPlanDto> addPrintPlan(@RequestBody PrintPlanDto planDto){
        PrintPlanDto save = printPlanService.save(planDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping
    public ResponseEntity<List<PrintPlanDto>> listAllPlans() {
        return ResponseEntity.status(HttpStatus.OK).body(printPlanService.allData());
    }

    @GetMapping("/{printPlanId}")
    public ResponseEntity<PrintPlanDto> findPlanById(@PathVariable long printPlanId) {
        PrintPlanDto byId = printPlanService.findById(printPlanId);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PutMapping("/{planId}")
    public ResponseEntity<PrintPlanDto> updatePrintPlan(@PathVariable long planId,@RequestBody PrintPlanDto planDto){
        PrintPlanDto update = printPlanService.update(planDto, planId);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<PrintPlanDto> deletePrintPlan(@PathVariable long planId){
        printPlanService.deleteById(planId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
