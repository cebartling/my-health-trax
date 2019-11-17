package org.myhealthtrax.healthservices.entities;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

//@Data
//@Entity
//@Table(name = "heart_rate_measurements")
//@EntityListeners(AuditingEntityListener.class)
public class HeartRateMeasurement {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Type(type = "org.hibernate.type.PostgresUUIDType")
//    private UUID id;
//
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "user_device_id")
////    private UserDevice userDevice;
//
//    @NotNull
//    private Integer value;
//
//    @NotNull
//    private Timestamp measuredAt;
//
//    @CreatedDate
//    @Column(name = "created_at")
//    private Timestamp createdAt;
//
//    @LastModifiedDate
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
}
