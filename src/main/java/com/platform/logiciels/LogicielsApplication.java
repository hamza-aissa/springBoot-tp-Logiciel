package com.platform.logiciels;

import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.services.LogicielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogicielsApplication implements CommandLineRunner {
    @Autowired
    LogicielService logicielService;
    public static void main(String[] args) {
        SpringApplication.run(LogicielsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logicielService.saveLogiciel(new Logiciel("Logiciel1", "1.0", 100.0f, java.sql.Date.valueOf("2023-01-01"), "Dev1"));
        logicielService.saveLogiciel(new Logiciel("Logiciel2", "1.1", 150.0f, java.sql.Date.valueOf("2023-02-01"), "Dev2"));
        logicielService.saveLogiciel(new Logiciel("Logiciel3", "1.2", 200.0f, java.sql.Date.valueOf("2023-03-01"), "Dev3"));
    }
}
