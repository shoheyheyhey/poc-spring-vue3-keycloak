package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Price;
import lombok.Builder;

@Builder public class PaymentMethodDetail {
    public final String paymentMethodName;
    public final Price paymentAmount;

    public PaymentMethodDetail(String paymentMethodName, Price paymentAmount) {
        this.paymentMethodName = paymentMethodName;
        this.paymentAmount = paymentAmount;
    }
}
