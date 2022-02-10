package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Price;

public class PaymentMethod {
    public final String paymentMethodName;
    public final Price paymentAmount;

    PaymentMethod(String paymentMethodName, Price paymentAmount) {
        this.paymentMethodName = paymentMethodName;
        this.paymentAmount = paymentAmount;
    }
}
