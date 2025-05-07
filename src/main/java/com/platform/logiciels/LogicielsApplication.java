package com.platform.logiciels;

import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.entities.Devloppeur;
import com.platform.logiciels.services.LogicielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class LogicielsApplication implements CommandLineRunner {
    @Autowired
    LogicielService logicielService;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(LogicielsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Logiciel.class);
    }
}
