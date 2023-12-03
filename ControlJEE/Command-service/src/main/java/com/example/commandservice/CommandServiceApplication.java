package com.example.commandservice;

import com.example.commandservice.Dao.CommandDAO;
import com.example.commandservice.module.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner strat(CommandDAO commandDAO) {
        return args -> {
            commandDAO.save(new Command(null, "asme", "asmae2kk", 200.1, 5));
            commandDAO.save(new Command(null, "asme2", "asma44e2kk", 200.1, 5));
            commandDAO.save(new Command(null, "asme4", "asmae442kk", 200.1, 5));

        };
    }
}

