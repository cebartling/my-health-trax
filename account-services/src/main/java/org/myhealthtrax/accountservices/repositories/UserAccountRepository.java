package org.myhealthtrax.accountservices.repositories;

import org.myhealthtrax.accountservices.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, String> {

    /**
     * Retrieve a list of user accounts tied to an email address.
     *
     * @param email
     * @return
     */
    List<UserAccount> findByEmail(String email);

    /**
     * Retrieve a single user account by its primary key.
     *
     * @param id
     * @return
     */
    Optional<UserAccount> findById(String id);
}
