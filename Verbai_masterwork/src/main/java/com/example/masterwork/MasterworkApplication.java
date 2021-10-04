package com.example.masterwork;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MasterworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterworkApplication.class, args);
    }

}
