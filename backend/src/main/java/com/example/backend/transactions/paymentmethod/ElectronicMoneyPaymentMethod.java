package com.example.backend.transactions.paymentmethod;


/** 電子マネー決済手段 */
public class ElectronicMoneyPaymentMethod implements WithdrawalTransactionPaymentMethod{
    final PaymentMethodId paymentMethodId;
    final PaymentMethodType paymentMethodType;

    public ElectronicMoneyPaymentMethod(String paymentMethodId, String paymentMethodType) {
        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.paymentMethodType = PaymentMethodType.getTypeByCode(paymentMethodType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeWithdrawalService(WithdrawalService withdrawalService) {
        withdrawalService.electronicMoneyWithdrawalService.execute(this);
    }



}
