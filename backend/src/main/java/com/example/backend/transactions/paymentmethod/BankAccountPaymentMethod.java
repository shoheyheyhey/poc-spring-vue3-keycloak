package com.example.backend.transactions.paymentmethod;


/** 銀行口座決済手段 */
public class BankAccountPaymentMethod implements WithdrawalTransactionPaymentMethod{
    final PaymentMethodId paymentMethodId;
    final PaymentMethodType paymentMethodType;

    public BankAccountPaymentMethod(String paymentMethodId, String paymentMethodType) {
        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.paymentMethodType = PaymentMethodType.getTypeByCode(paymentMethodType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeWithdrawalService(WithdrawalService withdrawalService) {
        withdrawalService.bankAccountWithdrawalService.execute(this);
    }

}
