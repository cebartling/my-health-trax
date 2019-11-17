package org.myhealthtrax.healthservices.graphql.datafetchers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserDeviceDataFetchers {

//    private final UserDeviceRepository userDeviceRepository;
//
//    @Autowired
//    public UserDeviceDataFetchers(UserDeviceRepository userDeviceRepository) {
//        this.userDeviceRepository = userDeviceRepository;
//    }

//    public DataFetcher getUserByEmailDataFetcher() {
//        return environment -> {
//            final var arguments = environment.getArguments();
//            final String email = arguments.get("email").toString();
//            User user = null;
//            final var UsersByEmail = UserRepository.findByEmail(email);
//            if (UsersByEmail.size() != 0) {
//                user = UsersByEmail.get(0);
//            }
//            return user;
//        };
//    }

//    public DataFetcher getCreateUserDataFetcher() {
//        return environment -> {
//            final var arguments = environment.getArguments();
//            final var inputMap = (Map<String, Object>) arguments.get("UserInput");
//            final var UserInput = UserInput.fromMap(inputMap);
//
//            final var UsersByEmail = UserRepository.findByEmail(UserInput.getEmail());
//            if (UsersByEmail.size() == 0) {
//                final var unpersisted = new User();
//                unpersisted.setEmail(UserInput.getEmail());
//                unpersisted.setFamilyName(UserInput.getFamilyName());
//                unpersisted.setGivenName(UserInput.getGivenName());
//                unpersisted.setLocale(UserInput.getLocale());
//                return this.UserRepository.save(unpersisted);
//            } else {
//                return UsersByEmail.get(0);
//            }
//        };
//    }
}
