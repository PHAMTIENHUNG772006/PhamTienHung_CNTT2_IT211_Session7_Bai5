package com.re.session7.service;

import com.re.session7.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    public void performTransaction(Transaction tx) {

        saveTransactionToDatabase(tx);
    }

    private void saveTransactionToDatabase(Transaction tx) {
        System.out.println("Lưu transaction: " + tx);
    }
}

