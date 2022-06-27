package com.example.backend.transactions.paymentmethod;

import com.example.backend.shared.exception.DomainException;

public interface DepositTransactionPaymentMethod {

    /**
     * 入金サービス実行
     * @param depositService
     */
    public void executeDepositService(DepositService depositService);

    static DepositTransactionPaymentMethod factoryPaymentMethod(String paymentMethodId,
            String paymentMethodType) {
        if (PaymentMethodType.PREPAID_CARD.getCode().equals(paymentMethodType)) {
            return new PrepaidCardPaymentMethod(paymentMethodId, paymentMethodType);

        }
        throw new DomainException("不正な決済手段です");
    }
}
