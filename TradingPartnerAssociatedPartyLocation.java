package com.jbhunt.infrastructure.notification.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jbhunt.infrastructure.audit.entity.AuditEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "TradingPartnerAssociatedPartyLocation", schema = "SUB")
public class TradingPartnerAssociatedPartyLocation extends AuditEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TradingPartnerAssociatedPartyID")
    private Integer tradingPartnerAssociatedPartyID;
    
    @Column(name = "TradingPartnerCode",nullable=false)
    private String tradingPartnerCode;
    
    @Column(name="PartyID")
    private Integer partyId;
    
    @Column(name="PartyRoleCode")
    private String partyRoleCode;
    
    @Column(name = "PickupLocationID")
    private Integer pickupLocationID;
    
    @Column(name = "DeliveryLocationID")
    private Integer deliveryLocationID;
    
    @Column(name = "FinanceBusinessUnitCode")
    private String financeBusinessUnitCode;
    
    @Column(name = "ServiceOfferingCode")
    private String serviceOfferingCode;

    @Column(name = "EffectiveTimestamp")
    private LocalDateTime effectiveTimestamp;

    @Column(name = "ExpirationTimestamp")
    private LocalDateTime expirationTimestamp;

}
