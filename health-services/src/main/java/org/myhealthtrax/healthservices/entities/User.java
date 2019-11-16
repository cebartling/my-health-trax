package org.myhealthtrax.healthservices.entities;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

    @ReadOnlyProperty
    private Timestamp createdAt;

    @ReadOnlyProperty
    private Timestamp updatedAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserDevice> userDevices = new ArrayList<>();
}
