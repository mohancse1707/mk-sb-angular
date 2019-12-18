/*
 * Copyright (c) 2019. MK Groups.
 * All rights reserved.
 * All data of MK groups are confidential.
 */

package com.mohan.springboot.app.model.token;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "TOKEN_GENERATOR")
public class TokenGenerator implements Serializable {
    private static final long serialVersionUID = 8918647207465043931L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TOKEN_ID")
    private Long tokenId;

    @Column(name = "STORE_ID")
    private Long serviceId;

    @Column(name = "STORE_CODE")
    private String storeCode;

    @Column(name = "ISSUED_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @Column(name = "DATE_FORMAT")
    private String dateFormat;

    @Column(name = "ISSUED_DATE_VALUE")
    private Long issuedDateValue;

    @Column(name = "DECIMAL_PADDING")
    private Long decimalPadding;

    @Column(name = "SEQUENCE_NO")
    private Long sequenceNumber;

    @Column(name = "GENERATED_TOKEN_NUMBER")
    private String tokenNumber;

    public TokenGenerator() {
        //TODO
    }

    public TokenGenerator(TokenGenerator tokenGenerator) {
        this.tokenId = tokenGenerator.getTokenId();
        this.serviceId = tokenGenerator.getServiceId();
        this.storeCode = tokenGenerator.getStoreCode();
        this.issueDate = tokenGenerator.getIssueDate();
        this.dateFormat = tokenGenerator.getDateFormat();
        this.issuedDateValue = tokenGenerator.getIssuedDateValue();
        this.decimalPadding = tokenGenerator.getDecimalPadding();
        this.sequenceNumber = tokenGenerator.getSequenceNumber();
        this.tokenNumber = tokenGenerator.getTokenNumber();
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Long getDecimalPadding() {
        return decimalPadding;
    }

    public void setDecimalPadding(Long decimalPadding) {
        this.decimalPadding = decimalPadding;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Long getIssuedDateValue() {
        return issuedDateValue;
    }

    public void setIssuedDateValue(Long issuedDateValue) {
        this.issuedDateValue = issuedDateValue;
    }
}
