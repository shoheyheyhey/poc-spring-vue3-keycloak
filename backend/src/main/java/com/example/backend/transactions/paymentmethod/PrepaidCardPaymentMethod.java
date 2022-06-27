package com.example.backend.transactions.paymentmethod;


/** プリペイドカード決済手段 */
public class PrepaidCardPaymentMethod implements WithdrawalTransactionPaymentMethod, DepositTransactionPaymentMethod{
    final PaymentMethodId paymentMethodId;
    final PaymentMethodType paymentMethodType;

    public PrepaidCardPaymentMethod(String paymentMethodId, String paymentMethodType) {
        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.paymentMethodType = PaymentMethodType.getTypeByCode(paymentMethodType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeWithdrawalService(WithdrawalService withdrawalService) {
        withdrawalService.prepaidCardWithdrawalService.execute(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeDepositService(DepositService depositService) {
        depositService.prepaidCardDepositService.execute(this);
    }



}
