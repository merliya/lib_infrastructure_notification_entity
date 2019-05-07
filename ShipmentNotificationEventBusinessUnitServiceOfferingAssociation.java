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
@Table(name = "ShipmentNotificationEventBusinessUnitServiceOfferingAssociation", schema = "SUB")
public class ShipmentNotificationEventBusinessUnitServiceOfferingAssociation extends AuditEntity implements Serializable {
    
    private static final long serialVersionUID = 5287280564047865273L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipmentNotificationEventBusinessUnitServiceOfferingAssociationID")
    private Integer shipmentNotificationEventBusinessUnitServiceOfferingAssociationID;

    @Column(name = "EffectiveTimestamp")
    private LocalDateTime effectiveTimestamp;

    @Column(name = "ExpirationTimestamp")
    private LocalDateTime expirationTimestamp;

    @Column(name = "FinanceBusinessUnitServiceOfferingAssociationID")
    private int financeBusinessUnitServiceOfferingAssociationID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentNotificationEventID")
    private ShipmentNotificationEvent shipmentNotificationEvent;

}
