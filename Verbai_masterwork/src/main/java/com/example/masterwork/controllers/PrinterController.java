package com.example.masterwork.controllers;

import com.example.masterwork.entities.Printer;
import com.example.masterwork.entities.PrinterDto;
import com.example.masterwork.services.PrinterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/printers")
public class PrinterController {

    final
    PrinterService printerService;


    public PrinterController(PrinterService printerService) {
        this.printerService = printerService;
    }

    @PostMapping
    public ResponseEntity<PrinterDto> addPrinter(@RequestBody PrinterDto printerDto) {
        PrinterDto printerDto1 = printerService.save(printerDto);
        return ResponseEntity.status(HttpStatus.OK).body(printerDto1);
    }

    @GetMapping
    public ResponseEntity<List<PrinterDto>> listAllPrinter(){
        return ResponseEntity.status(HttpStatus.OK).body(printerService.allData());
    }

    @GetMapping("/{printerId}")
    public ResponseEntity<Printer> findPrinterById(@PathVariable long printerId){
        return ResponseEntity.status(HttpStatus.OK).body(printerService.findById(printerId));
    }

    @PutMapping("/{printerId}")
    public ResponseEntity<Printer> updatePrinter(@PathVariable long printerId,@RequestBody Printer printer){
        printerService.update(printer,printerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{printerId}")
    public ResponseEntity<Printer> deletePrinter(@PathVariable long printerId){
        printerService.deleteById(printerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
