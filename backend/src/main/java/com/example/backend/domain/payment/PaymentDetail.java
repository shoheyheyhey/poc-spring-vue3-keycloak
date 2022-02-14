package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Price;
import lombok.Builder;

@Builder public class PaymentDetail {
    public final String itemName;
    public final Price unitPrice;

    public PaymentDetail(String itemName, Price unitPrice) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }

}
