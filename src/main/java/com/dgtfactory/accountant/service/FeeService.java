package com.dgtfactory.accountant.service;

import com.dgtfactory.accountant.model.Fee;
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

        Fee fee = new Fee();
        fee.setTransactionType(feeInput.getTransactionType());
        fee.setFee(resultFee);
        fee.setFeeCurrency(feeInput.getCurrency());
        fee.setComment("dummy comment");

        Fee savedFee = feeRepository.save(fee);

        FeeOutput feeOutput = mapToFeeOutput(savedFee);
        feeRepository.save(fee);

        return feeOutput;
    }

    private BigDecimal calculateFixedFee(FeeInput feeInput) {
        return BigDecimal.valueOf(10);
    }

    private BigDecimal calculatePercentageFee(FeeInput feeInput) {
        BigDecimal percentage = BigDecimal.valueOf(0.03);

        return feeInput.getAmount().multiply(percentage).setScale(2, RoundingMode.HALF_EVEN);
    }

    private FeeOutput mapToFeeOutput(Fee fee) {
        FeeOutput output = new FeeOutput();
        output.setFeeId(fee.getId());
        output.setTransactionType(fee.getTransactionType());
        output.setFee(fee.getFee());
        output.setCurrency(fee.getFeeCurrency());
        output.setCalculatedAt(fee.getCreatedAt());
        output.setComment(fee.getComment());
        return output;
    }
}
