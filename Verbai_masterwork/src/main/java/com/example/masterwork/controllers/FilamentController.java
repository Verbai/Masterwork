package com.example.masterwork.controllers;

import com.example.masterwork.entities.FilamentDto;
import com.example.masterwork.services.FilamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filaments")
public class FilamentController {

    final
    FilamentService filamentService;

    public FilamentController(FilamentService filamentService) {
        this.filamentService = filamentService;
    }


    @PostMapping
    public ResponseEntity<FilamentDto> addFilament(@RequestBody FilamentDto filament){
        FilamentDto filamentDto1 = filamentService.save(filament);
        return ResponseEntity.status(HttpStatus.CREATED).body(filamentDto1);
    }

    @GetMapping
    public ResponseEntity<List<FilamentDto>> getFilaments(){
        return ResponseEntity.status(HttpStatus.OK).body(filamentService.allData());
    }

    @GetMapping("/{filamentId}")
    public  ResponseEntity<FilamentDto> getFilamentById(@PathVariable long filamentId){
        FilamentDto filamentDto = filamentService.findById(filamentId);
        return ResponseEntity.status(HttpStatus.OK).body(filamentDto);
    }

    @GetMapping("/material/{material}")
    @ResponseBody
    public ResponseEntity<List<FilamentDto>> getFilamentsByMaterial(@PathVariable("material") String material){
        return ResponseEntity.status(HttpStatus.OK).body(filamentService.findByMaterialName(material));
    }

    @GetMapping("/heavierThan/{wheight}")
    @ResponseBody
    public ResponseEntity<List<FilamentDto>> getFilamentsWhichHeavierThan(@PathVariable("wheight") Double wheight){
        return ResponseEntity.status(HttpStatus.OK).body(filamentService.listAllFilamentWithRightWeight(wheight));
    }

    @PutMapping("/{filamentId}")
    public ResponseEntity<FilamentDto> updateFilament(@PathVariable long filamentId, @RequestBody FilamentDto filamentDto){
        FilamentDto entity = filamentService.update(filamentId,filamentDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(entity);
    }


    @DeleteMapping("/{filamentId}")
    public ResponseEntity<FilamentDto> deleteFilament(@PathVariable long filamentId){
        filamentService.deleteById(filamentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

