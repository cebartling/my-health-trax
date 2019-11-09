package org.myhealthtrax.accountservices.graphql.inputs;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@Builder
public class UserAccountInput {

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

    @NotNull
    private String locale;

    @NotNull
    private String email;

    public static UserAccountInput fromMap(Map<String, Object> arguments) {
        return UserAccountInput.builder()
                .email(arguments.get("email").toString())
                .familyName(arguments.get("familyName").toString())
                .givenName(arguments.get("givenName").toString())
                .locale(arguments.get("locale").toString())
                .build();
    }
}
