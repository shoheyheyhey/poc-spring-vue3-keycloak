package com.example.backend.domain.payment.value;

import com.example.backend.domain.shared.exception.DomainException;

public class Price {
    public final int value;

    // -1,000,000~1,000,000までの金額しか取り扱わない(0円は取り扱わない)
    public Price(int value) {
        if ((-1000000 > value) || (value > 1000000) || (value == 0)) {
            throw new DomainException("想定外の価格です");
        }
        this.value = value;
    }

}
