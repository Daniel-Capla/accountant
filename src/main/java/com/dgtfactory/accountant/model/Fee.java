package com.dgtfactory.accountant.model;

import com.dgtfactory.accountant.model.enums.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id = null;

    @Enumerated(EnumType.STRING)
    TransactionType transactionType;

    BigDecimal fee;
    String feeCurrency;

    @CreationTimestamp(source = SourceType.DB)
    Instant createdAt = null;

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

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    protected String comment;
}
