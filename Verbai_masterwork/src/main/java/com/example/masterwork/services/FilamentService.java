package com.example.masterwork.services;

import com.example.masterwork.entities.FilamentDto;

import java.util.List;


public interface FilamentService {
    FilamentDto save(FilamentDto filament);

    FilamentDto findById(Long filamentId);

    FilamentDto update(long filamentId, FilamentDto filamentDto);

    List<FilamentDto> allData();

    List<FilamentDto> findByMaterialName(String material);

    List<FilamentDto> listAllFilamentWithRightWeight(Double weight);

    void deleteById(long filamentId);
}
