package com.dgtfactory.accountant.service;

import com.dgtfactory.accountant.model.dto.FeeInput;
import com.dgtfactory.accountant.model.dto.FeeOutput;
import com.dgtfactory.accountant.repository.FeeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class FeeService {
    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public FeeOutput calculateFee(FeeInput feeInput) {

        BigDecimal resultFee = switch (feeInput.getTransactionType()) {
            case FIXED -> calculateFixedFee(feeInput);
            case PERCENTAGE -> calculatePercentageFee(feeInput);
        };

        FeeOutput result = new FeeOutput();
        result.setFee(resultFee);
        result.setCurrency(feeInput.getCurrency());
        result.setTransactionType(feeInput.getTransactionType());
        result.setComment("dummy comment");

        return result;
    }

    private BigDecimal calculateFixedFee(FeeInput feeInput) {
        return BigDecimal.valueOf(10);
    }

    private BigDecimal calculatePercentageFee(FeeInput feeInput) {
        BigDecimal percentage = BigDecimal.valueOf(0.03);

        return feeInput.getAmount().multiply(percentage).setScale(2, RoundingMode.HALF_EVEN);
    }
}
