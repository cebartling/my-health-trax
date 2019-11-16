package org.myhealthtrax.healthservices.graphql.inputs;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class UserInput {

//    @NotNull
//    private String givenName;

    public static UserInput fromMap(Map<String, Object> arguments) {
        return UserInput.builder()
//                .email(arguments.get("email").toString())
                .build();
    }
}
