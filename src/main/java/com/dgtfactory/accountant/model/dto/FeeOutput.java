package com.dgtfactory.accountant.model.dto;

import com.dgtfactory.accountant.model.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class FeeOutput {
    private UUID feeId;
    private TransactionType transactionType;
    private BigDecimal fee;
    private String currency;
    private Instant calculatedAt;
    private String comment;

    public FeeOutput() {
    }

    public UUID getFeeId() {
        return feeId;
    }

    public void setFeeId(UUID feeId) {
        this.feeId = feeId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Instant getCalculatedAt() {
        return calculatedAt;
    }

    public void setCalculatedAt(Instant calculatedAt) {
        this.calculatedAt = calculatedAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "FeeOutput{" +
                "feeId=" + feeId +
                ", transactionType=" + transactionType +
                ", fee=" + fee +
                ", currency='" + currency + '\'' +
                ", calculatedAt=" + calculatedAt +
                ", comment='" + comment + '\'' +
                '}';
    }
}
