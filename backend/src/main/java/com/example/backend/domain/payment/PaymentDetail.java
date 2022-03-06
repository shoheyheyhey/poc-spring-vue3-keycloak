package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;

public class PaymentDetail {
    public final String itemName;
    public final Price unitPrice;
    public final Point grantPoint;

    public PaymentDetail(String itemName, Price unitPrice) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.grantPoint = new Point((int) Math.ceil(unitPrice.value * 0.01));
    }

}
