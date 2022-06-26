package com.example.backend.transactions.paymentmethod;

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

    public static PaymentMethodType getTypeByCode(String str)
    {
        for(PaymentMethodType v : values())
        {
            if(v.getCode().equals(str))
            {
                return v;
            }
        }
        throw new IllegalArgumentException("undefined : " + str);
    }
}
