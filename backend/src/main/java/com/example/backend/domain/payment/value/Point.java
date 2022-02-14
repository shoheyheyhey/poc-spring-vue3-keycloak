package com.example.backend.domain.payment.value;

import com.example.backend.domain.shared.exception.DomainException;

public class Point {
    public final int value;

    // 0~1,000,000までのポイントしか取り扱わない
    public Point(int value) {
        if (value < 0 || 1000000 < value) {
            throw new DomainException("想定外のポイントです");
        }
        this.value = value;
    }

}
