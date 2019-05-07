package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jbhunt.infrastructure.audit.entity.AuditEntity;
import com.querydsl.core.annotations.QueryInit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "UserNotificationSubscription", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "userNotificationSubscriptionID", scope = UserNotificationSubscription.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserNotificationSubscription extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserNotificationSubscriptionID")
	private int userNotificationSubscriptionID;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;
//JISAMP2
	@Column(name = "ApplicationID")
	private String applicationID;


	// bi-directional many-to-one association to
	// UserNotificationSubscriptionAssociation
	@OneToMany(mappedBy = "userNotificationSubscription", cascade = CascadeType.ALL)
	@QueryInit("notificationType.*.*")
	@JsonBackReference
	private List<UserNotificationSubscriptionAssociation> userNotificationSubscriptionAssociations;

	// bi-directional many-to-one association to
	// UserNotificationSubscriptionCriteria
	@OneToMany(mappedBy = "userNotificationSubscription", cascade = CascadeType.ALL)
	@QueryInit("notificationParameter.*.*.*.*")
	@JsonBackReference
	private List<UserNotificationSubscriptionCriteria> userNotificationSubscriptionCriterias;

	// bi-directional many-to-one association to
	// UserNotificationSubscriptionDetail
	@OneToMany(mappedBy = "userNotificationSubscription", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<UserNotificationSubscriptionDetail> userNotificationSubscriptionDetails;
}
