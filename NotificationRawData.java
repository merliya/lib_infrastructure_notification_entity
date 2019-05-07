package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.util.List;

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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "NotificationRawData", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationRawDataID", scope = NotificationRawData.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationRawData extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationRawDataID")
	private int notificationRawDataID;

	@Column(name = "ApplicationDomainCode")
	private String applicationDomainCode;

	@Column(name = "NotificationRawDataContent")
	private String notificationRawDataContent;

	// bi-directional many-to-one association to
	// NotificationRawDataLogAssociation
	@OneToMany(mappedBy = "notificationRawData")
	@JsonBackReference(value="notificationRawDataLogAssociations")
	private List<NotificationRawDataLogAssociation> notificationRawDataLogAssociations;

}
