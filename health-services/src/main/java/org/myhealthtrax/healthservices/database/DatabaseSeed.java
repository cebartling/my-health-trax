package org.myhealthtrax.healthservices.database;

import lombok.extern.slf4j.Slf4j;
import org.myhealthtrax.healthservices.repositories.HeartRateMeasurementRepository;
import org.myhealthtrax.healthservices.repositories.UserDeviceRepository;
import org.myhealthtrax.healthservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DatabaseSeed {

    private final UserRepository userRepository;
    private final UserDeviceRepository userDeviceRepository;
    private final HeartRateMeasurementRepository heartRateMeasurementRepository;

    @Autowired
    public DatabaseSeed(UserRepository userRepository,
                        UserDeviceRepository userDeviceRepository,
                        HeartRateMeasurementRepository heartRateMeasurementRepository) {
        this.userRepository = userRepository;
        this.userDeviceRepository = userDeviceRepository;
        this.heartRateMeasurementRepository = heartRateMeasurementRepository;
    }

    public void execute() {
        log.info("===============================");
        log.info("=== START: Database seeding ===");
        log.info("===============================");
        //			String email = "john.jones@example.com";
//			if (repository.findByEmail(email).size() == 0) {
//				UserAccount userAccount = new UserAccount();
//				userAccount.setEmail(email);
//				userAccount.setGivenName("John");
//				userAccount.setFamilyName("Jones");
//				userAccount.setLocale("en-us");
//				repository.save(userAccount);
//			}
//
//			email = "jane.jones@example.com";
//			if (repository.findByEmail(email).size() == 0) {
//				UserAccount userAccount = new UserAccount();
//				userAccount.setEmail(email);
//				userAccount.setGivenName("Jane");
//				userAccount.setFamilyName("Jones");
//				userAccount.setLocale("en-us");
//				repository.save(userAccount);
//			}
//
//			// fetch all customers
//			log.info("UserAccounts found with findAll():");
//			log.info("-------------------------------");
//			for (UserAccount userAccount : repository.findAll()) {
//				log.info(userAccount.toString());
//			}
//			log.info("");
        log.info("================================");
        log.info("=== FINISH: Database seeding ===");
        log.info("================================");
    }
}


