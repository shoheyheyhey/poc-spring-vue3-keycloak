package com.example.backend.transactions.paymentmethod;


/** クレジットカード決済手段 */
public class CreditCardPaymentMethod implements WithdrawalTransactionPaymentMethod{
    final PaymentMethodId paymentMethodId;
    final PaymentMethodType paymentMethodType;

    public CreditCardPaymentMethod(String paymentMethodId, String paymentMethodType) {
        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.paymentMethodType = PaymentMethodType.getTypeByCode(paymentMethodType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeWithdrawalService(WithdrawalService withdrawalService) {
        withdrawalService.creditCardWithdrawalService.execute(this);
    }



}
