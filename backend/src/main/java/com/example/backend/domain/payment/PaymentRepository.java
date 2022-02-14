package com.example.backend.domain.payment;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PaymentRepository {
    public void insert(Payment payment);
    public Payment findById(String receiptId);
}
