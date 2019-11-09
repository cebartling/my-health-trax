package org.myhealthtrax.accountservices.graphql.datafetchers;

import graphql.schema.DataFetchingEnvironment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.myhealthtrax.accountservices.entities.UserAccount;
import org.myhealthtrax.accountservices.repositories.UserAccountRepository;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserAccountDataFetchersTest {

    @Mock
    private UserAccountRepository userAccountRepository;

    @Mock
    private DataFetchingEnvironment dataFetchingEnvironment;

    @InjectMocks
    private UserAccountDataFetchers subject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserAccountByEmailDataFetcher_returnsDataFetcherImpl() {
        final var dataFetcher = subject.getUserAccountByEmailDataFetcher();
        assertNotNull(dataFetcher);
    }

    @Test
    void getUserAccountByEmailDataFetcher_executeDataFetcher() throws Exception {
        final var dataFetcher = subject.getUserAccountByEmailDataFetcher();
        final var expectedEmail = "joe@example.com";
        final var arguments = new HashMap<String, Object>();
        arguments.put("email", expectedEmail);
        when(dataFetchingEnvironment.getArguments()).thenReturn(arguments);
        final var userAccountsList = new ArrayList<UserAccount>();
        userAccountsList.add(new UserAccount());
        when(userAccountRepository.findByEmail(expectedEmail)).thenReturn(userAccountsList);

        final var output = dataFetcher.get(dataFetchingEnvironment);

        assertNotNull(output);
        verify(dataFetchingEnvironment).getArguments();
        verify(userAccountRepository).findByEmail(expectedEmail);
    }

    @Test
    void getCreateUserAccountDataFetcher() {
        final var dataFetcher = subject.getCreateUserAccountDataFetcher();
        assertNotNull(dataFetcher);
    }


    @Test
    void getCreateUserAccountDataFetcher_executeDataFetcher() throws Exception {
        final var dataFetcher = subject.getCreateUserAccountDataFetcher();
        final var arguments = new HashMap<String, Object>();
        final var inputMap = new HashMap<String, Object>();
        inputMap.put("email", "joe@example.com");
        inputMap.put("familyName", "Smith");
        inputMap.put("givenName", "Joseph");
        inputMap.put("locale", "en-us");
        arguments.put("userAccountInput", inputMap);
        when(dataFetchingEnvironment.getArguments()).thenReturn(arguments);
        UserAccount savedUserAccount = new UserAccount();
        when(userAccountRepository.save(any(UserAccount.class))).thenReturn(savedUserAccount);

        final var output = dataFetcher.get(dataFetchingEnvironment);

        assertEquals(output, savedUserAccount);
        verify(dataFetchingEnvironment).getArguments();
        verify(userAccountRepository).save(any(UserAccount.class));
    }
}