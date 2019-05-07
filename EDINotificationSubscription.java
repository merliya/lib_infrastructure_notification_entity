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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "ShipmentNotificationSubscription", schema = "SUB")
public class EDINotificationSubscription extends AuditEntity implements Serializable {

    private static final long serialVersionUID = -9130531155278972693L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipmentNotificationSubscriptionID")
    private Integer ediNotificationSubscriptionID;

    @Column(name = "EffectiveTimestamp")
    private LocalDateTime effectiveTimestamp;

    @Column(name = "ExpirationTimestamp")
    private LocalDateTime expirationTimestamp;

    @Column(name = "ShipmentNotificationBatchFrequency")
    private Short ediNotificationBatchFrequency;

    @Column(name = "ShipmentNotificationTimeDelay")
    private Short ediNotificationTimeDelay;

    @Column(name = "TradingPartnerCode")
    private String tradingPartnerCode;

    @Column(name = "UnitOfTimeMeasurementCode")
    private String unitOfTimeMeasurementCode;
    
    @Column(name = "LoadTenderTimeDelay")
    private Short ediNotificationLoadTenderTimeDelay;
    
    @Column(name = "LoadTenderUnitOfTimeMeasurementCode")
    private String loadTenderUnitOfTimeMeasurementCode;
    
    @Column(name = "ElectronicDataInterchangeSubscriptionIndicator")
    private Character electronicDataInterchangeSubscriptionIndicator;

    @OneToOne(mappedBy = "shipmentNotificationSubscription", cascade=CascadeType.ALL, orphanRemoval=true)
    private InTransitNotificationSubscription inTransitNotificationSubscription;

    @OneToMany(mappedBy = "shipmentNotificationSubscription", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LoadTenderEventSubscription> loadTenderEventSubscriptions;

    @OneToMany(mappedBy = "shipmentNotificationSubscription")
    private List<NotificationLog> notificationLogs;

    @OneToMany(mappedBy = "shipmentNotificationSubscription", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ShipmentNotificationSubscriptionEventAssociation> shipmentNotificationSubscriptionEventAssociations;

    @OneToOne(mappedBy = "shipmentNotificationSubscription", cascade=CascadeType.ALL, orphanRemoval=true)
    private ShipmentNotificationSubscriptionHold shipmentNotificationSubscriptionHold;

    @OneToOne(mappedBy = "shipmentNotificationSubscription", cascade=CascadeType.ALL, orphanRemoval=true)
    private ShipmentNotificationSubscriptionReferenceNumber shipmentNotificationSubscriptionReferenceNumber;

}
