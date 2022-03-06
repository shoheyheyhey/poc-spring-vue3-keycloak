package com.example.backend.domain.payment.value;

import com.example.backend.domain.shared.exception.DomainException;

public class PointRate {
    public final double value;

    // 0~1,000,000までのポイントしか取り扱わない
    public PointRate(double value) {
        if (value < 0 || 1 < value) {
            throw new DomainException("想定外のポイント率です");
        }
        this.value = value;
    }

}
