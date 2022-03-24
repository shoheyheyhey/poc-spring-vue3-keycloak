package com.example.backend.shared;

import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.value.Price;

public class TestPaymentMethodDetailFactory {

    static private final String paymentMethodName = "creditCard";
    static private final Price paymentAmount = new Price(2000);

    /**
     * デフォルト設定で支払方法明細作成
     *
     * @return
     */
    public static PaymentMethodDetail create() {
        return new PaymentMethodDetail(paymentMethodName,paymentAmount);
    }


}
