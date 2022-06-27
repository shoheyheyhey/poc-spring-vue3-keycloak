package com.example.backend.transactions.paymentmethod;

import com.example.backend.shared.exception.DomainException;

public interface WithdrawalTransactionPaymentMethod {

    /**
     * 出金サービス実行
     * @param withdrawalService 出金サービス
     */
    void executeWithdrawalService(WithdrawalService withdrawalService);

    static WithdrawalTransactionPaymentMethod factoryPaymentMethod(String paymentMethodId,
            String paymentMethodType) {
        if(PaymentMethodType.BANK_ACCOUNT.getCode().equals(paymentMethodType)) {
            return new BankAccountPaymentMethod(paymentMethodId, paymentMethodType);
        }
        if (PaymentMethodType.CREDIT_CARD.getCode().equals(paymentMethodType)) {
            return new CreditCardPaymentMethod(paymentMethodId, paymentMethodType);
        }
        if (PaymentMethodType.PREPAID_CARD.getCode().equals(paymentMethodType)) {
            return new PrepaidCardPaymentMethod(paymentMethodId, paymentMethodType);
        }
        if (PaymentMethodType.ELECTRONIC_MONEY.getCode().equals(paymentMethodType)) {
            return new ElectronicMoneyPaymentMethod(paymentMethodId, paymentMethodType);
        }
        throw new DomainException("不正な決済手段です");
    }
}
