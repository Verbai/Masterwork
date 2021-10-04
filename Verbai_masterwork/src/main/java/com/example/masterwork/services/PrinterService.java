package com.example.masterwork.services;

import com.example.masterwork.entities.Printer;
import com.example.masterwork.entities.PrinterDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrinterService {
    public PrinterDto save(PrinterDto printerDto);

    List<PrinterDto> allData();

    Printer findById(long id);

    Printer update(Printer printer, long printerId);

    void deleteById(long printerId);
}
