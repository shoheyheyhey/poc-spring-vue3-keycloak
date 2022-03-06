package com.example.backend.domain.shared;

import com.example.backend.domain.payment.value.PointRate;

public class CashPaymentMethod implements PaymentMethod {


    @Override public PointRate pointRate() {
        return new PointRate(0.01);
    }
}
