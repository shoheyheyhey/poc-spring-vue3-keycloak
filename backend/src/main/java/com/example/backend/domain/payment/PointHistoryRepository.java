package com.example.backend.domain.payment;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface PointHistoryRepository {

    public void insert(PointHistory pointHistory);
}
