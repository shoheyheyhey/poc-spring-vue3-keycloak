package com.example.backend.transactions.appuser;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionAppUserRepository {
    public TransactionAppUser findById(AppUserId appUserId);
}
