package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

@Data
@Entity
@Table(name = "UserNotificationSubscriptionDetail", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "userNotificationSubscriptionDetailID", scope = UserNotificationSubscriptionDetail.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserNotificationSubscriptionDetail extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserNotificationSubscriptionDetailID")
	private int userNotificationSubscriptionDetailID;

	@Column(name = "SubscribedBlindCarbonCopyEmailAddress")
	private String subscribedBlindCarbonCopyEmailAddress;

	@Column(name = "SubscribedCarbonCopyEmailAddress")
	private String subscribedCarbonCopyEmailAddress;

	@Column(name = "SubscribedEmailAddress")
	private String subscribedEmailAddress;

	@Column(name = "SubscribedUserID")
	private String subscribedUserID;

	@Column(name = "SubscribedPhoneNumber")
	private String subscribedPhoneNumber;
	
	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;
	
	@Column(name = "SubscribedUserIDSourceName")
	private String subscribedUserIDSourceName;

	@Column(name = "UnsubscribeURL")
	private String UnsubscribeUrl;
//JISAMP2
	@Column(name = "SubscribedEmailType")
	private String subscribedEmailType;

	// bi-directional many-to-one association to NotificationLog
	@OneToMany(mappedBy = "userNotificationSubscriptionDetail")
	@JsonBackReference
	private List<NotificationLog> notificationLogs;

	// bi-directional many-to-one association to
	// NotificationSubscriptionDeliveryMethod
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationSubscriptionDeliveryMethodCode")
	@JsonManagedReference
	private NotificationSubscriptionDeliveryMethod notificationSubscriptionDeliveryMethod;

	// bi-directional many-to-one association to UserNotificationSubscription
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserNotificationSubscriptionID")
	@JsonManagedReference
	private UserNotificationSubscription userNotificationSubscription;
}
