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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "NotificationSubscriptionDeliveryMethodAssociation", schema = "SUB")
//@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationSubscriptionDeliveryMethodAssociationID", scope = NotificationSubscriptionDeliveryMethodAssociation.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationSubscriptionDeliveryMethodAssociation extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationSubscriptionDeliveryMethodAssociationID")
	private int notificationSubscriptionDeliveryMethodAssociationID;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	// bi-directional many-to-one association to
	// NotificationSubscriptionDeliveryMethod
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationSubscriptionDeliveryMethodCode")
	@JsonManagedReference
	private NotificationSubscriptionDeliveryMethod notificationSubscriptionDeliveryMethod;

	// bi-directional many-to-one association to NotificationType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationTypeID")
	@JsonManagedReference
	private NotificationType notificationType;

}
