package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "ShipmentNotificationEventType", schema = "SUB")
public class ShipmentNotificationEventType extends AuditEntity implements Serializable{

    private static final long serialVersionUID = -2689147638565721715L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ShipmentNotificationEventTypeCode")
    private String shipmentNotificationEventTypeCode;
    
    @Column(name="ShipmentNotificationEventTypeDescription")
    private String shipmentNotificationEventTypeDescription;

    @Column(name="EffectiveTimestamp")
    private LocalDateTime effectiveTimestamp;

    @Column(name="ExpirationTimestamp")
    private LocalDateTime expirationTimestamp;
    
}
