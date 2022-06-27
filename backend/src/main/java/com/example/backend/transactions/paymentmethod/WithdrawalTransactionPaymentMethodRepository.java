package com.example.backend.transactions.paymentmethod;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WithdrawalTransactionPaymentMethodRepository {
    WithdrawalTransactionPaymentMethod findById(PaymentMethodId paymentMethodId);
}
