package com.dgtfactory.accountant.model.dto;

import com.dgtfactory.accountant.model.enums.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class FeeInput {
    @NotNull(message = "Transaction Type must be provided")
    private TransactionType transactionType;

    @NotNull
    @DecimalMin(value = "10.00", message = "Amount must be greater than 10")
    private BigDecimal amount;

    @Size(min = 3, max = 3, message = "Currency must be 3 characters long")
    private String currency = "EUR";

    public FeeInput() {
    }

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
