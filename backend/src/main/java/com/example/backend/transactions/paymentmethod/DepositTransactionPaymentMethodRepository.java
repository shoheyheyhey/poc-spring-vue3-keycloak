package com.example.backend.transactions.paymentmethod;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DepositTransactionPaymentMethodRepository {
    DepositTransactionPaymentMethod findById(PaymentMethodId paymentMethodId);
}
