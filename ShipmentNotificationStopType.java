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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "ShipmentNotificationStopType", schema = "SUB")
public class ShipmentNotificationStopType extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipmentNotificationStopTypeCode")
	private String shipmentNotificationStopTypeCode;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	@Column(name = "ShipmentNotificationStopTypeDescription")
	private String shipmentNotificationStopTypeDescription;

	// bi-directional many-to-one association to
	// ShipmentNotificationStopReasonEventTypeAssociation
	@OneToMany(mappedBy = "shipmentNotificationStopType")
	@JsonManagedReference
	private List<ShipmentNotificationStopReasonEventTypeAssociation> shipmentNotificationStopReasonEventTypeAssociations;

}
