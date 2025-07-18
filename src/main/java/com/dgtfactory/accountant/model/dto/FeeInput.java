package com.dgtfactory.accountant.model.dto;

import com.dgtfactory.accountant.model.enums.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class FeeInput {
    @NotNull
    TransactionType transactionType;
    @NotNull
    BigDecimal amount;

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

    String currency = "EUR";
}
