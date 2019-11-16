package org.myhealthtrax.healthservices.entities;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;




@Data
@Entity
@Table(name = "heart_rate_measurements")
public class HeartRateMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @NotNull
    private UUID userDeviceId;

    @NotNull
    private Integer value;

    @NotNull
    private Timestamp measuredAt;

    @ReadOnlyProperty
    private Timestamp createdAt;

    @ReadOnlyProperty
    private Timestamp updatedAt;
}
