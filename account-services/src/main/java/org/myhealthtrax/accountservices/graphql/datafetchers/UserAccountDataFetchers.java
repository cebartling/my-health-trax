package org.myhealthtrax.accountservices.graphql.datafetchers;

import graphql.schema.DataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.myhealthtrax.accountservices.entities.UserAccount;
import org.myhealthtrax.accountservices.graphql.inputs.UserAccountInput;
import org.myhealthtrax.accountservices.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class UserAccountDataFetchers {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountDataFetchers(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public DataFetcher getUserAccountByEmailDataFetcher() {
        return environment -> {
            final var arguments = environment.getArguments();
            final String email = arguments.get("email").toString();
            UserAccount userAccount = null;
            final var userAccountsByEmail = userAccountRepository.findByEmail(email);
            if (userAccountsByEmail.size() != 0) {
                userAccount = userAccountsByEmail.get(0);
            }
            return userAccount;
        };
    }

    public DataFetcher getCreateUserAccountDataFetcher() {
        return environment -> {
            final var arguments = environment.getArguments();
            final var inputMap = (Map<String, Object>) arguments.get("userAccountInput");
            final var userAccountInput = UserAccountInput.fromMap(inputMap);
            final var unpersisted = new UserAccount();
            unpersisted.setEmail(userAccountInput.getEmail());
            unpersisted.setFamilyName(userAccountInput.getFamilyName());
            unpersisted.setGivenName(userAccountInput.getGivenName());
            unpersisted.setLocale(userAccountInput.getLocale());
            final var persisted = this.userAccountRepository.save(unpersisted);
            return persisted;
        };
    }
}
