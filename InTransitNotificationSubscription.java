package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "InTransitNotificationSubscription", schema = "SUB")
public class InTransitNotificationSubscription extends AuditEntity implements Serializable {

    private static final long serialVersionUID = 8542652445022025274L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InTransitNotificationSubscriptionID")
    private Integer inTransitNotificationSubscriptionID;

    @Column(name = "InTransitNotificationFrequency")
    private Integer inTransitNotificationFrequency;

    @Column(name = "UnitOfTimeMeasurementCode")
    private String unitOfTimeMeasurementCode;
    
    @Column(name = "EffectiveTimestamp")
    private LocalDateTime effectiveTimestamp;
    
    @Column(name="ExpirationTimestamp")
    private LocalDateTime expirationTimestamp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentNotificationSubscriptionID")
    private EDINotificationSubscription shipmentNotificationSubscription;

}
