package com.re.session7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transaction {
    @Id
    private String transactionId;
    private double amount;
    private String senderWallet;
    private String receiverWallet;
}
