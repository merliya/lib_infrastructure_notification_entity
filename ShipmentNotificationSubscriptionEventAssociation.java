package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;

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
@Table(name = "ShipmentNotificationSubscriptionEventAssociation", schema = "SUB")
public class ShipmentNotificationSubscriptionEventAssociation extends AuditEntity implements Serializable {
    
    private static final long serialVersionUID = -5859186819764857413L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipmentNotificationSubscriptionEventAssociationID")
    private Integer shipmentNotificationSubscriptionEventAssociationID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentNotificationEventID")
    private ShipmentNotificationEvent shipmentNotificationEvent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentNotificationSubscriptionID")
    private EDINotificationSubscription shipmentNotificationSubscription;

}
