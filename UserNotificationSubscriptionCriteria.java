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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "UserNotificationSubscriptionCriteria", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "userNotificationSubscriptionCriteriaID", scope = UserNotificationSubscriptionCriteria.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserNotificationSubscriptionCriteria extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserNotificationSubscriptionCriteriaID")
	private int userNotificationSubscriptionCriteriaID;

	@Column(name = "UserNotificationSubscriptionParameterValue")
	private String userNotificationSubscriptionParameterValue;

	// bi-directional many-to-one association to NotificationParameter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationParameterID")
	@JsonManagedReference
	private NotificationParameter notificationParameter;

	// bi-directional many-to-one association to UserNotificationSubscription
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserNotificationSubscriptionID")
	@JsonManagedReference
	private UserNotificationSubscription userNotificationSubscription;
}
