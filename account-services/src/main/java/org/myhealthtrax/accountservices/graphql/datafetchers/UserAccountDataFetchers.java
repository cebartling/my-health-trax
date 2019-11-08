package org.myhealthtrax.accountservices.graphql.datafetchers;

import graphql.schema.DataFetcher;
import org.myhealthtrax.accountservices.entities.UserAccount;
import org.myhealthtrax.accountservices.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAccountDataFetchers {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountDataFetchers(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public DataFetcher getUserAccountByEmailDataFetcher() {
        return environment -> {
            final var variables = environment.getVariables();
            final String email = variables.get("email").toString();
            UserAccount userAccount = null;
            final var userAccountsByEmail = userAccountRepository.findByEmail(email);
            if (userAccountsByEmail.size() != 0) {
                userAccount = userAccountsByEmail.get(0);
            }
            return userAccount;
        };
    }
}
