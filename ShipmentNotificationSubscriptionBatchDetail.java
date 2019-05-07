package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

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
@Table(name = "ShipmentNotificationSubscriptionBatchDetail", schema = "SUB")
public class ShipmentNotificationSubscriptionBatchDetail extends AuditEntity implements Serializable{
	private static final long serialVersionUID = -6331979059568401560L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShipmentNotificationSubscriptionBatchDetailID")
	private Integer shipmentNotificationSubscriptionBatchDetailID;
	
	@Column(name = "ShipmentNotificationSubscriptionInTransitRunTimestamp")
	private OffsetDateTime shipmentNotificationSubscriptionInTransitRunTimestamp;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationSubscriptionID")
	private EDINotificationSubscription ediNotificationSubscription;
	

}
