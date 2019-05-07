package com.jbhunt.infrastructure.notification.entity;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "JBHEmailTemplate", schema = "SUB")
public class JBHEmailTemplate extends AuditEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "JBHEmailTemplateID")
    private int jbhEmailTemplateID;

    @Column(name = "SourceTemplateID")
    private String sourceTemplateID;

    @Column(name="EmailTemplateName")
    private String emailTemplateName;
}
