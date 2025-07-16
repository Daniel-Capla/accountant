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
    String comment;
}
