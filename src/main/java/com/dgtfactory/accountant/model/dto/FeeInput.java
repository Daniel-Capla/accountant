package com.dgtfactory.accountant.model.dto;

import com.dgtfactory.accountant.model.enums.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class FeeInput {
    @NotNull
    private TransactionType transactionType;
    @NotNull
    private BigDecimal amount;
    private String currency = "EUR";

    // Default constructor pre Jackson
    public FeeInput() {
    }

    // Gettery a settery
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "FeeInput{" +
                "transactionType=" + transactionType +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
