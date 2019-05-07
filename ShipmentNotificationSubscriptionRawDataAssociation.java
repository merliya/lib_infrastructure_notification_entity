package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;
import com.jbhunt.infrastructure.notification.entity.converter.DateTimeAttributeConverter;

import lombok.Data;

@Data
@Entity
@Table(name = "ShipmentNotificationSubscriptionRawDataAssociation", schema = "SUB")
public class ShipmentNotificationSubscriptionRawDataAssociation extends AuditEntity implements Serializable {
	

    private static final long serialVersionUID = 2207304763745238081L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipmentNotificationSubscriptionRawDataAssociationID")
	private Integer shipmentNotificationSubscriptionRawDataAssociationID;

    @Column(name="OrderId")
    private Integer orderId;
    
	@Column(name = "BatchCalculatedTransmissionTimestamp")
	@Convert(converter=DateTimeAttributeConverter.class)
	private LocalDateTime batchCalculatedTransmissionTimestamp;
	
	
	@Column(name = "TimeDelayCalculatedTransmissionTimestamp")
	@Convert(converter=DateTimeAttributeConverter.class)
	private LocalDateTime timeDelayCalculatedTransmissionTimestamp;

	// bi-directional many-to-one association to
	// ShipmentNotificationStopEventType
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationSubscriptionID")
	private EDINotificationSubscription ediNotificationSubscription;

	// bi-directional many-to-one association to ShipmentNotificationStopType
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationRawDataID")
	private NotificationRawData notificationRawData;

	
}
