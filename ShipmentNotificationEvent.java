package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "ShipmentNotificationEvent", schema = "SUB")
public class ShipmentNotificationEvent extends AuditEntity implements Serializable {

    private static final long serialVersionUID = -7488510624758845250L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ShipmentNotificationEventID")
    private Integer shipmentNotificationEventID;

    @Column(name="EffectiveTimestamp")
    private LocalDateTime effectiveTimestamp;

    @Column(name="ExpirationTimestamp")
    private LocalDateTime expirationTimestamp;

    @Column(name="ShipmentNotificationEventName")
    private String shipmentNotificationEventName;

    @JsonIgnore
    @OneToMany(mappedBy="shipmentNotificationEvent")
    private List<LoadTenderEventSubscription> loadTenderEventSubscriptions;

    @JsonIgnore
    @OneToMany(mappedBy="shipmentNotificationEvent")
    private List<ShipmentNotificationEventBusinessUnitServiceOfferingAssociation> shipmentNotificationEventBusinessUnitServiceOfferingAssociations;

    @JsonIgnore
    @OneToMany(mappedBy="shipmentNotificationEvent")
    private List<ShipmentNotificationSubscriptionEventAssociation> shipmentNotificationSubscriptionEventAssociations;
    
    @JsonIgnore
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ShipmentNotificationEventTypeCode")
    private ShipmentNotificationEventType shipmentNotificationEventType;

}
