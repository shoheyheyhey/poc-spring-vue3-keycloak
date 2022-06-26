package com.example.backend.transactions.paymentmethod;


/** 取引決済手段 */
public class TransactionPaymentMethod {
    final PaymentMethodId paymentMethodId;
    final PaymentMethodType paymentMethodType;

    public TransactionPaymentMethod(String paymentMethodId, String paymentMethodType) {

        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.paymentMethodType = PaymentMethodType.getTypeByCode(paymentMethodType);


    }

}
