package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Price;

public class PaymentDetail {
    public final String itemName;
    public final Price price;

    PaymentDetail(String itemName, Price price) {
        this.itemName = itemName;
        this.price = price;
    }

}
