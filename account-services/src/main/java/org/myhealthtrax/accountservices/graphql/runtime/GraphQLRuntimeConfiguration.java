package org.myhealthtrax.accountservices.graphql.runtime;

import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.myhealthtrax.accountservices.graphql.datafetchers.UserAccountDataFetchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class GraphQLRuntimeConfiguration {

    private final UserAccountDataFetchers userAccountDataFetchers;

    @Autowired
    public GraphQLRuntimeConfiguration(UserAccountDataFetchers userAccountDataFetchers) {
        this.userAccountDataFetchers = userAccountDataFetchers;
    }

    @Bean
    public RuntimeWiring.Builder runtimeWiringBuilder() {
        final var builder = RuntimeWiring.newRuntimeWiring();
        builder.type(buildQueryTypeWiring());
//        builder.type(buildUserAccountTypeWiring());
        return builder;
    }

    private TypeRuntimeWiring.Builder buildQueryTypeWiring() {
        final var builder = newTypeWiring("Query");
        builder.dataFetcher("userAccountByEmail", userAccountDataFetchers.getUserAccountByEmailDataFetcher());
        return builder;
    }

//    private TypeRuntimeWiring.Builder buildUserAccountTypeWiring() {
//        final var typeWiring = newTypeWiring("UserAccount");
//        typeWiring.dataFetcher("permissions", userAccountDataFetchers.getPermissionsDataFetcher());
//        newTypeWiring("Book")
//                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher())
//        return typeWiring;
//    }
}
