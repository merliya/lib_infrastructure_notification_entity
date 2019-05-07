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
@Table(name = "ShipmentNotificationStopReasonEventTypeAssociation", schema = "SUB")
public class ShipmentNotificationStopReasonEventTypeAssociation extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipmentNotificationStopReasonEventTypeAssociationID")
	private int shipmentNotificationStopReasonEventTypeAssociationID;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	@Column(name = "StopReasonCode")
	private String stopReasonCode;

	// bi-directional many-to-one association to
	// ShipmentNotificationStopEventType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationStopEventTypeCode")
	private ShipmentNotificationStopEventType shipmentNotificationStopEventType;

	// bi-directional many-to-one association to ShipmentNotificationStopType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationStopTypeCode")
	private ShipmentNotificationStopType shipmentNotificationStopType;

	
}
