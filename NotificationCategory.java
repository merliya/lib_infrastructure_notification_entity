package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "NotificationCategory", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationCategoryCode", scope = NotificationCategory.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationCategory extends AuditEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NotificationCategoryCode")
	private String notificationCategoryCode;

	@Column(name = "ApplicationDomainCode")
	private String applicationDomainCode;

	@Column(name = "EffectiveTimestamp")
	private LocalDateTime effectiveTimestamp;

	@Column(name = "ExpirationTimestamp")
	private LocalDateTime expirationTimestamp;

	@Column(name = "NotificationCategoryDescription")
	private String notificationCategoryDescription;

	// bi-directional many-to-one association to NotificationSubCategory
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "notificationCategory")
	@JsonBackReference
	private List<NotificationSubCategory> notificationSubCategories;

	// bi-directional many-to-one association to NotificationType
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "notificationCategory")
	@JsonBackReference
	private List<NotificationType> notificationTypes;

}
