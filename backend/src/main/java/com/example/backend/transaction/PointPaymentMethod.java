package com.example.backend.transaction;


import com.example.backend.domain.shared.exception.DomainException;
import com.example.backend.share.PaymentMethodType;

/** ポイント決済手段 */
public class PointPaymentMethod {
    public final PaymentMethodId paymentMethodId;
    public final PaymentMethodType paymentMethodType;

    public PointPaymentMethod(String paymentMethodId, String paymentMethodType) {

        if (PaymentMethodType.PREPAID_CARD.getCode() != paymentMethodType) {
            throw new DomainException("不正なポイント決済手段です");
        }

        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.paymentMethodType = PaymentMethodType.valueOf(paymentMethodType);

    }

}
