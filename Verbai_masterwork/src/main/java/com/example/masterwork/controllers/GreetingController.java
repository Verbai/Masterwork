package com.example.masterwork.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Value("${localName}")
    private String localName;

    @GetMapping()
    public ResponseEntity<String> greeting(){
        return ResponseEntity.status(HttpStatus.OK).body("Szia "+localName+"!");
    }

}

