package com.re.session7.aspect;

import com.re.session7.custom_exception.HighRiskException;
import com.re.session7.custom_exception.InvalidAddressException;
import com.re.session7.model.Transaction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DoingAspect {

    @Before("execution(* com.re.session7.service.TransactionService.performTransaction(..)) && args(tx)")
    public void validateTransaction(JoinPoint jp, Transaction tx) {
        if (tx.getAmount() < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (tx.getReceiverWallet().length() < 5) {
            throw new InvalidAddressException("Wallet address too short");
        }
        if (tx.getAmount() > 10000) {
            throw new HighRiskException("Transaction exceeds 10,000 USD");
        }
    }

    @AfterReturning(pointcut = "execution(* com.re.session7.service.TransactionService.performTransaction(..))", returning = "result")
    public void logSuccess(JoinPoint jp, Object result) {
        System.out.println("Transaction success: " + jp.getArgs()[0]);
    }

    @AfterThrowing(pointcut = "execution(* com.re.session7.service.TransactionService.performTransaction(..))", throwing = "ex")
    public void logError(JoinPoint jp, Exception ex) {
        System.err.println("Transaction failed: " + ex.getMessage());
    }
}
