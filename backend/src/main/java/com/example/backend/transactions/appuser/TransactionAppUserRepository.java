package com.example.backend.transactions.appuser;

public interface TransactionAppUserRepository {
    TransactionAppUser findById(AppUserId appUserId);
}
