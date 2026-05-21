package com.re.session7.controller;

import com.re.session7.model.Transaction;
import com.re.session7.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping
    public ResponseEntity<String> createTransaction(@RequestBody Transaction tx) {
        transactionService.performTransaction(tx);
        return ResponseEntity.ok("Xử lý giao dịch thành công");
    }
}
