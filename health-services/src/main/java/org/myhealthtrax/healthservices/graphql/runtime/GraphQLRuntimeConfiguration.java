package org.myhealthtrax.healthservices.graphql.runtime;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.TypeRuntimeWiring;
import org.myhealthtrax.healthservices.graphql.datafetchers.UserDataFetchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class GraphQLRuntimeConfiguration {

    private final UserDataFetchers userDataFetchers;

    @Autowired
    public GraphQLRuntimeConfiguration(UserDataFetchers userDataFetchers) {
        this.userDataFetchers = userDataFetchers;
    }

    @Bean
    public RuntimeWiring.Builder runtimeWiringBuilder() {
        final var builder = RuntimeWiring.newRuntimeWiring();
        builder.scalar(ExtendedScalars.DateTime);
        builder.scalar(ExtendedScalars.PositiveInt);
        builder.type(buildQueryTypeWiring());
        builder.type(buildMutationTypeWiring());
//        builder.type(buildUserTypeWiring());
        return builder;
    }

    private TypeRuntimeWiring.Builder buildMutationTypeWiring() {
        final var builder = newTypeWiring("Mutation");
//        builder.dataFetcher("createUser", userDataFetchers.getCreateUserDataFetcher());
        return builder;
    }

    private TypeRuntimeWiring.Builder buildQueryTypeWiring() {
        final var builder = newTypeWiring("Query");
//        builder.dataFetcher("userByEmail", userDataFetchers.getUserByEmailDataFetcher());
        return builder;
    }

//    private TypeRuntimeWiring.Builder buildUserTypeWiring() {
//        final var typeWiring = newTypeWiring("User");
//        typeWiring.dataFetcher("permissions", userDataFetchers.getPermissionsDataFetcher());
//        newTypeWiring("Book")
//                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher())
//        return typeWiring;
//    }
}
