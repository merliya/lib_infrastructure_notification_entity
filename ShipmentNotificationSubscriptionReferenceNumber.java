package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;

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
@Table(name = "ShipmentNotificationSubscriptionReferenceNumber", schema = "SUB")
public class ShipmentNotificationSubscriptionReferenceNumber extends AuditEntity implements Serializable {

    private static final long serialVersionUID = 7372074457713630206L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipmentNotificationSubscriptionReferenceNumberID")
	private int shipmentNotificationSubscriptionReferenceNumberID;

	@Column(name = "ReferenceNumberTypeCode")
	private String referenceNumberTypeCode;

	// bi-directional many-to-one association to
	// ShipmentNotificationSubscription
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationSubscriptionID")
	private EDINotificationSubscription shipmentNotificationSubscription;

}
