package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;
import com.jbhunt.infrastructure.notification.entity.converter.DateTimeAttributeConverter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "NotificationLog", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationLogID", scope = NotificationLog.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationLog extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationLogID")
	private int notificationLogID;

	@Lob
	@Column(name = "NotificationLogContent")
	private String notificationLogContent;

	@Column(name = "ReadReceiptTimestamp")
    @Convert(converter = DateTimeAttributeConverter.class)
	private LocalDateTime readReceiptTimestamp;
	
	@Column(name = "SubscribedUserID")
	private String subscribedUserID;
	
	@Column(name = "NotificationSubscriptionDeliveryMethodCode")
	private String notificationSubscriptionDeliveryMethodCode;

	// bi-directional many-to-one association to
	// ShipmentNotificationSubscription
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentNotificationSubscriptionID")
	@JsonManagedReference
	private EDINotificationSubscription shipmentNotificationSubscription;

	// bi-directional many-to-one association to
	// UserNotificationSubscriptionDetail
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserNotificationSubscriptionDetailID")
	@JsonManagedReference
	private UserNotificationSubscriptionDetail userNotificationSubscriptionDetail;

	// bi-directional many-to-one association to NotificationLogResponse
	@OneToMany(mappedBy = "notificationLog")
	@JsonBackReference
	private List<NotificationLogResponse> notificationLogResponses;

	// bi-directional many-to-one association to
	// NotificationRawDataLogAssociation
	@OneToMany(mappedBy = "notificationLog")
	@JsonBackReference
	private List<NotificationRawDataLogAssociation> notificationRawDataLogAssociations;
}
