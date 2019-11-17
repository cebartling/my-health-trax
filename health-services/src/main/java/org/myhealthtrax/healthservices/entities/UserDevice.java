package org.myhealthtrax.healthservices.entities;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Data
//@Entity
//@Table(name = "user_devices")
//@EntityListeners(AuditingEntityListener.class)
public class UserDevice {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type = "org.hibernate.type.PostgresUUIDType")
//    private UUID id;
//
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "user_id")
////    private User user;
//
//    @NotNull
//    private String name;
//
//    @CreatedDate
//    @Column(name = "created_at")
//    private Timestamp createdAt;
//
//    @LastModifiedDate
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<HeartRateMeasurement> heartRateMeasurements = new ArrayList<>();
}
