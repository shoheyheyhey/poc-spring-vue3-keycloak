package com.example.backend.transactions.settlement;

import org.springframework.transaction.annotation.Transactional;

@Transactional public interface SettlementTransactionRepository {
    public void insert(SettlementTransaction settlementTransaction);
}
