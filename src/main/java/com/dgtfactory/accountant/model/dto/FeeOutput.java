package com.dgtfactory.accountant.model.dto;

import com.dgtfactory.accountant.model.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class FeeOutput {
    UUID feeId;
    TransactionType transactionType;
    BigDecimal fee;
    String currency;
    Instant calculatedAt;

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCalculatedAt(Instant calculatedAt) {
        this.calculatedAt = calculatedAt;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    String comment;
}
