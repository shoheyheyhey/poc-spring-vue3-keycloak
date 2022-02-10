package com.example.backend.domain.payment.value;

import com.example.backend.domain.shared.exception.DomainException;
import java.time.LocalDate;

public class PaymentAndPointDate {
    public final LocalDate value;

    // 未来日は取り扱わない
    PaymentAndPointDate(LocalDate value) {
        if(LocalDate.now().isAfter(value)) {
            throw new DomainException("未来日は想定外です");
        }
        this.value = value;
    }
}