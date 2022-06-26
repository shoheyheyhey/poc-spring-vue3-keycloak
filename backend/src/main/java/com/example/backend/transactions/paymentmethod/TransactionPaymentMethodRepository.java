package com.example.backend.transactions.paymentmethod;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionPaymentMethodRepository {
    TransactionPaymentMethod findById(PaymentMethodId paymentMethodId);
}
