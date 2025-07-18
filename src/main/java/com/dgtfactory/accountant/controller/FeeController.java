package com.dgtfactory.accountant.controller;

import com.dgtfactory.accountant.model.dto.FeeInput;
import com.dgtfactory.accountant.model.dto.FeeOutput;
import com.dgtfactory.accountant.service.FeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeeController {
    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }


    @GetMapping("/fee")
    public ResponseEntity<FeeOutput> fee(
            @RequestBody FeeInput feeInput
    ) {
        FeeOutput feeOutput = feeService.calculateFee(feeInput);

        return ResponseEntity.status(HttpStatus.OK).body(feeOutput);
    }
}
