package org.myhealthtrax.accountservices.graphql.inputs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountInputTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void fromMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("email", "joe@example.com");
        map.put("familyName", "Schmoo");
        map.put("givenName", "Joe");
        map.put("locale", "en-us");
        final var actual = UserAccountInput.fromMap(map);
        assertNotNull(actual);
    }
}