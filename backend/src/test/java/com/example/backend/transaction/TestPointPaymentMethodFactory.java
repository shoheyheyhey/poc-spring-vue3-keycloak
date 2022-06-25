package com.example.backend.transaction;

import com.example.backend.transaction.PointPaymentMethod;

public class TestPointPaymentMethodFactory {
    static private final String paymentMethodId = "1";
    static private final String paymentMethodType = "prepaid_card";


    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static PointPaymentMethod create() {
        return new PointPaymentMethod(paymentMethodId, paymentMethodType);
    }

    public static PointPaymentMethod create(String paymentMethodType) {
        return new PointPaymentMethod(paymentMethodId, paymentMethodType);
    }

}
