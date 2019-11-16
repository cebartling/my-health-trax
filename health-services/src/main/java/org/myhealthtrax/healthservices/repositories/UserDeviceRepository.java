package org.myhealthtrax.healthservices.repositories;

import org.myhealthtrax.healthservices.entities.UserDevice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDeviceRepository extends CrudRepository<UserDevice, UUID> {

    /**
     * Retrieve a list of UserDevice objects by user id.
     *
     * @param uuid
     * @return A List of UserDevice objects associated with a user.
     */
    List<UserDevice> findByUserId(UUID uuid);

    /**
     * Retrieve a UserDevice objects by its id.
     *
     * @param uuid
     * @return An optional UserDevice objects.
     */
    Optional<UserDevice> findById(UUID uuid);
}
