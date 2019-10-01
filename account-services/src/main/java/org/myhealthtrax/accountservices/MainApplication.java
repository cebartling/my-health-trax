package org.myhealthtrax.accountservices;

import lombok.extern.slf4j.Slf4j;
import org.myhealthtrax.accountservices.entities.UserAccount;
import org.myhealthtrax.accountservices.repositories.UserAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserAccountRepository repository) {
        return (args) -> {
            String email = "john.jones@example.com";
            if (repository.findByEmail(email).size() == 0) {
                UserAccount userAccount = new UserAccount();
                userAccount.setEmail(email);
                userAccount.setGivenName("John");
                userAccount.setFamilyName("Jones");
                userAccount.setLocale("en-us");
                repository.save(userAccount);
            }

            email = "jane.jones@example.com";
            if (repository.findByEmail(email).size() == 0) {
                UserAccount userAccount = new UserAccount();
                userAccount.setEmail(email);
                userAccount.setGivenName("Jane");
                userAccount.setFamilyName("Jones");
                userAccount.setLocale("en-us");
                repository.save(userAccount);
            }

            // fetch all customers
            log.info("UserAccounts found with findAll():");
            log.info("-------------------------------");
            for (UserAccount userAccount : repository.findAll()) {
                log.info(userAccount.toString());
            }
            log.info("");
        };
    }
}
