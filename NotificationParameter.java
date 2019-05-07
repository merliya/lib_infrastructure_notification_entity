package com.jbhunt.infrastructure.notification.entity;

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

@Data
@Entity
@Table(name = "NotificationParameter", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationParameterID", scope = NotificationParameter.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationParameter extends AuditEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationParameterID")
	private int notificationParameterID;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	@Column(name = "NotificationParameterDescription")
	private String notificationParameterDescription;

	// bi-directional many-to-one association to NotificationType
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationTypeID")
	@JsonManagedReference
	private NotificationType notificationType;

	// bi-directional many-to-one association to
	// UserNotificationSubscriptionCriteria
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "notificationParameter")
	@JsonBackReference
	private List<UserNotificationSubscriptionCriteria> userNotificationSubscriptionCriterias;

}
