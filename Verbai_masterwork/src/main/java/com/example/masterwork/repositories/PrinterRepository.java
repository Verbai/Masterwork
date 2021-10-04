package com.example.masterwork.repositories;

import com.example.masterwork.entities.Filament;
import com.example.masterwork.entities.Printer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrinterRepository extends CrudRepository<Printer, Long> {
    List<Printer> findAll();

    @Query(value = "SELECT * FROM printer  WHERE accepted_filament_diameter = :diameter", nativeQuery = true)
    List<Printer> findCompatiblePrinter(Double diameter);

    @Query(value = "SELECT * FROM printer  WHERE name = :name", nativeQuery = true)
    Optional<Printer> findPrinterBYName(String name);

}