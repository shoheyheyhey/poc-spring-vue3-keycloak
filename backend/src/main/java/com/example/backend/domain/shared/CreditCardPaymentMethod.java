package com.example.backend.domain.shared;

import com.example.backend.domain.payment.value.PointRate;

public class CreditCardPaymentMethod implements PaymentMethod {

    @Override public PointRate pointRate() {
        return new PointRate(0.02);
    }
}
