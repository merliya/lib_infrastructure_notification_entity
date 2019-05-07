package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The persistent class for the NotificationType database table.
 * 
 */
@Data
@Entity
@Table(name = "NotificationType", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationTypeID", scope = NotificationType.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationType extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationTypeID")
	private int notificationTypeID;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	@Column(name = "NotificationDescription")
	private String notificationDescription;

	@Column(name = "NotificationTypeName")
	private String notificationTypeName;

	// bi-directional many-to-one association to NotificationParameter
	@OneToMany(mappedBy = "notificationType",fetch = FetchType.LAZY)
	private List<NotificationParameter> notificationParameters;

	// bi-directional many-to-one association to
	// NotificationSubscriptionDeliveryMethodAssociation
	@OneToMany(mappedBy = "notificationType",fetch = FetchType.LAZY)
	@JsonBackReference
	private List<NotificationSubscriptionDeliveryMethodAssociation> notificationSubscriptionDeliveryMethodAssociations;

	// bi-directional many-to-one association to NotificationCategory
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationCategoryCode")
	@JsonManagedReference
	private NotificationCategory notificationCategory;

	// bi-directional many-to-one association to NotificationSubCategory
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationSubCategoryCode")
	@JsonManagedReference
	private NotificationSubCategory notificationSubCategory;

	// bi-directional many-to-one association to
	// UserNotificationSubscriptionAssociation
	@OneToMany(mappedBy = "notificationType")
	@JsonBackReference
	private List<UserNotificationSubscriptionAssociation> userNotificationSubscriptionAssociations;

}