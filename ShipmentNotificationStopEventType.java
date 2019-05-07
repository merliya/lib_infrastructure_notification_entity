package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "ShipmentNotificationStopEventType", schema = "SUB")
public class ShipmentNotificationStopEventType extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipmentNotificationStopEventTypeCode")
	private String shipmentNotificationStopEventTypeCode;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	@Column(name = "ShipmentNotificationStopEventTypeDescription")
	private String shipmentNotificationStopEventTypeDescription;

	// bi-directional many-to-one association to
	// ShipmentNotificationStopReasonEventTypeAssociation
	@OneToMany(mappedBy = "shipmentNotificationStopEventType")
	private List<ShipmentNotificationStopReasonEventTypeAssociation> shipmentNotificationStopReasonEventTypeAssociations;

}
