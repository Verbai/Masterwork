package com.example.masterwork.repositories;

import com.example.masterwork.entities.Filament;
import com.example.masterwork.entities.FilamentDto;
import com.example.masterwork.entities.Printer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilamentRepository extends CrudRepository<Filament,Long> {
    List<Filament> findAll();

   @Query(value = "SELECT * FROM filament  WHERE material = :material", nativeQuery = true)
   List<Filament> findWhereMaterial(@Param("material") String material);

   @Query(value = "SELECT * FROM filament  WHERE weight >= :weight", nativeQuery = true)
   List<Filament> listAllFilamentWithRightWheight(Double weight);

    @Query(value = "SELECT * FROM filament  WHERE diameter = :diameter", nativeQuery = true)
    List<Filament> findCompatibleFilaments(Double diameter);
}
