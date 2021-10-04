package com.example.masterwork.controllers;

import com.example.masterwork.entities.FilamentDto;
import com.example.masterwork.entities.Printer;
import com.example.masterwork.services.FilamentService;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class FilamentControllerTest {
    List<FilamentDto> filamentDtoList = new ArrayList<>();

    @Autowired
    FilamentService filamentService;

    @Autowired
    Flyway flyway;

    @BeforeEach
    void setup() {
        flyway.migrate();
    }



    @Test
    public void saveFilamentSuccessfully() {

    }
}
