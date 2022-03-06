package com.example.backend.domain.shared;

import com.example.backend.domain.payment.value.PointRate;
import com.example.backend.domain.payment.value.Price;

public class ElectronicMoneyPaymentMethod implements PaymentMethod{

    @Override public PointRate pointRate() {
        return new PointRate(0.03);
    }
}
