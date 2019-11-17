package org.myhealthtrax.healthservices;

import lombok.extern.slf4j.Slf4j;
import org.myhealthtrax.healthservices.database.DatabaseSeed;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Slf4j
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
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

    @Bean
    public AuditorAware<String> auditorProvider() {

        /*
          if you are using spring security, you can get the currently logged username with following code segment.
          SecurityContextHolder.getContext().getAuthentication().getName()
         */
        return () -> Optional.ofNullable("chathuranga");
    }
}
