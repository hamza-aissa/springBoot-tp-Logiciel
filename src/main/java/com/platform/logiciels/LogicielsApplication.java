package com.platform.logiciels;

import com.platform.logiciels.entities.Logiciel;
import com.platform.logiciels.entities.Devloppeur;
import com.platform.logiciels.entities.Role;
import com.platform.logiciels.entities.User;
import com.platform.logiciels.services.LogicielService;
import com.platform.logiciels.services.UserService;
import jakarta.annotation.PostConstruct;
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
    private UserService userService;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(LogicielsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Logiciel.class);
    }
    /*
    @PostConstruct
    void init_users() {
        //ajouter les rôles
        userService.addRole(new Role(null,"ADMIN"));
        userService.addRole(new Role(null,"AGENT"));
        userService.addRole(new Role(null,"USER"));

        //ajouter les users
        userService.saveUser(new User(null,"admin","123",true,null));
        userService.saveUser(new User(null,"hamza","123",true,null));
        userService.saveUser(new User(null,"user1","123",true,null));

        //ajouter les rôles aux users
        userService.addRoleToUser("admin", "ADMIN");

        userService.addRoleToUser("nadhem", "USER");
        userService.addRoleToUser("nadhem", "AGENT");

        userService.addRoleToUser("user1", "USER");
    }

     */
}
