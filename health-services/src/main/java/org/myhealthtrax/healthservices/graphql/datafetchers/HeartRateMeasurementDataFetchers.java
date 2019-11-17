package org.myhealthtrax.healthservices.graphql.datafetchers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HeartRateMeasurementDataFetchers {

//    private final HeartRateMeasurementRepository heartRateMeasurementRepository;
//
//    @Autowired
//    public HeartRateMeasurementDataFetchers(HeartRateMeasurementRepository heartRateMeasurementRepository) {
//        this.heartRateMeasurementRepository = heartRateMeasurementRepository;
//    }

//    public DataFetcher getHeartRateMeasurementByEmailDataFetcher() {
//        return environment -> {
//            final var arguments = environment.getArguments();
//            final String email = arguments.get("email").toString();
//            HeartRateMeasurement heartRateMeasurement = null;
//            final var HeartRateMeasurementsByEmail = HeartRateMeasurementRepository.findByEmail(email);
//            if (HeartRateMeasurementsByEmail.size() != 0) {
//                heartRateMeasurement = HeartRateMeasurementsByEmail.get(0);
//            }
//            return heartRateMeasurement;
//        };
//    }

//    public DataFetcher getCreateHeartRateMeasurementDataFetcher() {
//        return environment -> {
//            final var arguments = environment.getArguments();
//            final var inputMap = (Map<String, Object>) arguments.get("HeartRateMeasurementInput");
//            final var HeartRateMeasurementInput = HeartRateMeasurementInput.fromMap(inputMap);
//
//            final var HeartRateMeasurementsByEmail = HeartRateMeasurementRepository.findByEmail(HeartRateMeasurementInput.getEmail());
//            if (HeartRateMeasurementsByEmail.size() == 0) {
//                final var unpersisted = new HeartRateMeasurement();
//                unpersisted.setEmail(HeartRateMeasurementInput.getEmail());
//                unpersisted.setFamilyName(HeartRateMeasurementInput.getFamilyName());
//                unpersisted.setGivenName(HeartRateMeasurementInput.getGivenName());
//                unpersisted.setLocale(HeartRateMeasurementInput.getLocale());
//                return this.HeartRateMeasurementRepository.save(unpersisted);
//            } else {
//                return HeartRateMeasurementsByEmail.get(0);
//            }
//        };
//    }
}
