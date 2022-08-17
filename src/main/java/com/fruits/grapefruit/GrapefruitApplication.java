package com.fruits.grapefruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.*;

@SpringBootApplication
@EnableCaching
public class GrapefruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrapefruitApplication.class, args);
    }
}
