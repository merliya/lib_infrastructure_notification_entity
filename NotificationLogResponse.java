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
@Table(name = "NotificationLogResponse", schema = "SUB")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "notificationLogReponseID", scope = NotificationLogResponse.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotificationLogResponse extends AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NotificationLogReponseID")
	private int notificationLogReponseID;

	@Column(name = "NotificationLogResponseContent")
	private String notificationLogResponseContent;

	@Column(name = "NotificationLogResponseType")
	private String notificationLogResponseType;

	@Column(name = "NotificationLogResponseTypeReason")
	private String notificationLogResponseTypeReason;

	// bi-directional many-to-one association to NotificationLog
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NotificationLogID")
	@JsonManagedReference
	private NotificationLog notificationLog;

}
