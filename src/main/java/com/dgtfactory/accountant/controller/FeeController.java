package com.dgtfactory.accountant.controller;

import com.dgtfactory.accountant.model.dto.FeeInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeeController {
    @GetMapping("/fee")
    public ResponseEntity<String> fee(
            @RequestBody FeeInput feeInput
    ) {
        return ResponseEntity.ok("");
    }
}
