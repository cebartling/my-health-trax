package org.myhealthtrax.healthservices.database;

import lombok.extern.slf4j.Slf4j;
import org.myhealthtrax.healthservices.entities.User;
import org.myhealthtrax.healthservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;

@Slf4j
@Component
public class DatabaseSeed {

    private final UserRepository userRepository;
//    private final UserDeviceRepository userDeviceRepository;
//    private final HeartRateMeasurementRepository heartRateMeasurementRepository;

    @Autowired
    public DatabaseSeed(UserRepository userRepository
//                        ,UserDeviceRepository userDeviceRepository
//                        ,HeartRateMeasurementRepository heartRateMeasurementRepository
    ) {
        this.userRepository = userRepository;
//        this.userDeviceRepository = userDeviceRepository;
//        this.heartRateMeasurementRepository = heartRateMeasurementRepository;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public void execute() {
        log.info("===============================");
        log.info("=== START: Database seeding ===");
        log.info("===============================");
        final var user = createUser();


        log.info("================================");
        log.info("=== FINISH: Database seeding ===");
        log.info("================================");
    }

    private User createUser() {
        String givenName = "Christopher";
        String familyName = "Bartling";

        final var users = userRepository.findAllByGivenNameAndFamilyName(givenName, familyName);
        User user;
        if (users.size() > 0) {
            log.info("   ==> Found an existing user!");
            user = users.get(0);
        } else {
            log.info("   ==> Creating a new user!");
            user = new User();
            user.setGivenName(givenName);
            user.setFamilyName(familyName);
            user = userRepository.save(user);
        }
        log.info(MessageFormat.format("   ==> User: {0}", user));
        return user;
    }
}


