package com.dgtfactory.accountant.messaging;

import com.dgtfactory.accountant.model.dto.FeeInput;
import com.dgtfactory.accountant.model.dto.FeeOutput;
import com.dgtfactory.accountant.service.FeeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FeeMessageListener {
    private final FeeService feeService;

    public FeeMessageListener(FeeService feeService) {
        this.feeService = feeService;
    }

    @RabbitListener(queues = "fees.calculate")
    public void handleMessage(FeeInput feeInput) {
        System.out.println("RabbitMQ message: " + feeInput);
        FeeOutput feeOutput = feeService.calculateFee(feeInput);
        System.out.println("Result: " + feeOutput);
    }
}
