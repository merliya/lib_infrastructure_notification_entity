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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "ShipmentNotificationSubscriptionHold", schema = "SUB")
public class ShipmentNotificationSubscriptionHold extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipmentNotificationSubscriptionHoldID")
	private Integer shipmentNotificationSubscriptionHoldID;

	// bi-directional many-to-one association to
	// ShipmentNotificationStopReasonEventTypeAssociation
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationStopReasonEventTypeAssociationID")
	private ShipmentNotificationStopReasonEventTypeAssociation shipmentNotificationStopReasonEventTypeAssociation;

	// bi-directional many-to-one association to
	// ShipmentNotificationSubscription
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationSubscriptionID")
	private EDINotificationSubscription shipmentNotificationSubscription;

}
