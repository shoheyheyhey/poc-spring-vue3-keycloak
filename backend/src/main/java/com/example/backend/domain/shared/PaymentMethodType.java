package com.example.backend.domain.shared;

import com.example.backend.domain.payment.value.PointRate;
import com.example.backend.usecase.payment.PaymentCreateParam;

public enum PaymentMethodType {
    cash(new CashPaymentMethod()),
    electronicMoney(new ElectronicMoneyPaymentMethod()),
    creditCard(new CreditCardPaymentMethod());

    private PaymentMethod paymentMethod;

    private PaymentMethodType(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PointRate pointRate() {
        return this.paymentMethod.pointRate();
    }

}
