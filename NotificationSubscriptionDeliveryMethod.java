package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "NotificationSubscriptionDeliveryMethod", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationSubscriptionDeliveryMethodCode", scope = NotificationSubscriptionDeliveryMethod.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationSubscriptionDeliveryMethod extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NotificationSubscriptionDeliveryMethodCode")
	private String notificationSubscriptionDeliveryMethodCode;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	@Column(name = "NotificationSubscriptionDeliveryMethodDescription")
	private String notificationSubscriptionDeliveryMethodDescription;

	// bi-directional many-to-one association to
	// NotificationSubscriptionDeliveryMethodAssociation
	@OneToMany(mappedBy = "notificationSubscriptionDeliveryMethod")
	@JsonBackReference
	private List<NotificationSubscriptionDeliveryMethodAssociation> notificationSubscriptionDeliveryMethodAssociations;

	// bi-directional many-to-one association to
	// UserNotificationSubscriptionDetail
	@OneToMany(mappedBy = "notificationSubscriptionDeliveryMethod")
	@JsonBackReference
	private List<UserNotificationSubscriptionDetail> userNotificationSubscriptionDetails;

}
