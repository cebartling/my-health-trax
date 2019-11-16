package org.myhealthtrax.healthservices.graphql.datafetchers;

import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.myhealthtrax.healthservices.entities.User;
import org.myhealthtrax.healthservices.graphql.inputs.UserInput;
import org.myhealthtrax.healthservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class UserDataFetchers {

    private final UserRepository userRepository;

    @Autowired
    public UserDataFetchers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DataFetcher getUserByIdDataFetcher() {
        return environment -> {
            final var arguments = environment.getArguments();
            final UUID id = UUID.fromString(arguments.get("id").toString());
            User user = null;
            Optional<User> holder = userRepository.findById(id);
            if (holder.isPresent()) {
                user = holder.get();
            }
            return user;
        };
    }

    public DataFetcher getCreateUserDataFetcher() {
        return environment -> {
            final var arguments = environment.getArguments();
            final var inputMap = (Map<String, Object>) arguments.get("userInput");
            final var userInput = UserInput.fromMap(inputMap);
            final var unpersisted = new User();
            return this.userRepository.save(unpersisted);
        };
    }
}
