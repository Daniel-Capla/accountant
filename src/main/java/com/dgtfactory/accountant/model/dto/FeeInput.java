package com.dgtfactory.accountant.model.dto;

import com.dgtfactory.accountant.model.enums.TransactionType;

import java.math.BigDecimal;

public class FeeInput {
    TransactionType transactionType;
    BigDecimal amount;
    String currency;
}
