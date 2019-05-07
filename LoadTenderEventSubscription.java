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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "LoadTenderEventSubscription", schema = "SUB")
public class LoadTenderEventSubscription extends AuditEntity implements Serializable {

    private static final long serialVersionUID = -8171899995712903422L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoadTenderEventSubscriptionID")
    private Integer loadTenderEventSubscriptionID;
    
    @Column(name = "EffectiveTimestamp")
    private LocalDateTime effectiveTimestamp;

    @Column(name = "ExpirationTimestamp")
    private LocalDateTime expirationTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentNotificationEventID")
    private ShipmentNotificationEvent shipmentNotificationEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentNotificationSubscriptionID")
    private EDINotificationSubscription shipmentNotificationSubscription;

}
