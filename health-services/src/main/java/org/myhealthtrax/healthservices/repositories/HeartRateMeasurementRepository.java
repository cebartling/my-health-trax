package org.myhealthtrax.healthservices.repositories;

import org.myhealthtrax.healthservices.entities.HeartRateMeasurement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HeartRateMeasurementRepository extends CrudRepository<HeartRateMeasurement, UUID> {

    /**
     * Retrieve a list of HeartRateMeasurement objects by user id.
     *
     * @param uuid
     * @return A List of HeartRateMeasurement objects associated with a user.
     */
    List<HeartRateMeasurement> findByUserDeviceId(UUID uuid);

    /**
     * Retrieve a HeartRateMeasurement objects by its id.
     *
     * @param uuid
     * @return An optional HeartRateMeasurement objects.
     */
    Optional<HeartRateMeasurement> findById(UUID uuid);
}
