package org.myhealthtrax.healthservices;

import lombok.extern.slf4j.Slf4j;
import org.myhealthtrax.healthservices.database.DatabaseSeed;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner databaseSeedRunner(DatabaseSeed databaseSeed) {
        return (args) -> {
            databaseSeed.execute();
        };
    }
}
