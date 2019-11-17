package org.myhealthtrax.healthservices.repositories;

import org.myhealthtrax.healthservices.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    /**
     * Retrieve a single user  by its primary key.
     *
     * @param id
     * @return
     */
    Optional<User> findById(UUID id);

    List<User> findAllByGivenNameAndFamilyName(String givenName, String familyName);
}
