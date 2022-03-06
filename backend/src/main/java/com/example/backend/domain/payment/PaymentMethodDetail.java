package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import com.example.backend.domain.shared.PaymentMethodType;

public class PaymentMethodDetail {
    public final String paymentMethodName;
    public final Price paymentAmount;
    public final Point grantPoint;

    public PaymentMethodDetail(String paymentMethodName, Price paymentAmount) {
        this.paymentMethodName = paymentMethodName;
        this.paymentAmount = paymentAmount;

        PaymentMethodType paymentMethodType = PaymentMethodType.valueOf(paymentMethodName);
        this.grantPoint = new Point(
                (int) Math.ceil(paymentAmount.value * paymentMethodType.pointRate().value));
    }
}
