package com.example.backend.transaction;


import com.example.backend.share.PaymentMethodType;

/** 取引決済手段 */
public class TransactionPaymentMethod {
    public final PaymentMethodId paymentMethodId;
    public final PaymentMethodType paymentMethodType;
    public final TransactionApplicableCampaignList transactionApplicableCampaignList;

    public TransactionPaymentMethod(String paymentMethodId, String paymentMethodType, TransactionApplicableCampaignList transactionApplicableCampaignList) {

        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.paymentMethodType = PaymentMethodType.valueOf(paymentMethodType);
        this.transactionApplicableCampaignList = transactionApplicableCampaignList;

    }

}
