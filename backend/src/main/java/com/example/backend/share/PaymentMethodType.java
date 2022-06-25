package com.example.backend.share;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentMethodType {
    CREDIT_CARD("credit_card"),
    ELECTRONIC_MONEY("electronic_money"),
    PREPAID_CARD("prepaid_card"),
    BANK_ACCOUNT("bank_account");

    private final String code;
}
