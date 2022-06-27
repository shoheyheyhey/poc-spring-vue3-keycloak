package com.example.backend.transactions.point;

import org.springframework.transaction.annotation.Transactional;

@Transactional public interface GrantPointRepository {
    public void insert(GrantPoint grantPoint);
}
