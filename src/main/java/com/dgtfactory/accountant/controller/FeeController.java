package com.dgtfactory.accountant.controller;

import com.dgtfactory.accountant.model.dto.FeeInput;
import com.dgtfactory.accountant.model.dto.FeeOutput;
import com.dgtfactory.accountant.service.FeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;

@RestController
public class FeeController {
    private final FeeService feeService;
    @Value("${application.key}")
    private String appkey;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @PostMapping("/fee")
    public ResponseEntity<FeeOutput> fee(
            @RequestParam String key,
            @RequestBody FeeInput feeInput
    ) {
        ensureCorrectKey(key);
        FeeOutput feeOutput = feeService.calculateFee(feeInput);

        return ResponseEntity.status(HttpStatus.OK).body(feeOutput);
    }

    private void ensureCorrectKey(String key) {
        if (!Objects.equals(key, appkey)) throw HttpClientErrorException.create(
                HttpStatus.UNAUTHORIZED,
                "Request has not been authorized",
                null,
                null,
                null
        );
    }
}
