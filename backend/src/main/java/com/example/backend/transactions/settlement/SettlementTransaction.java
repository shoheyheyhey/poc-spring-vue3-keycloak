package com.example.backend.transactions.settlement;

import com.example.backend.transactions.appuser.AppUserId;
import com.example.backend.transactions.paymentmethod.PaymentMethodId;
import com.example.backend.transactions.shop.ShopId;
import com.example.backend.transactions.TransactionId;

/**
 * 決済取引
 */
public class SettlementTransaction {
    public final TransactionId transactionId = new TransactionId();
    final SettlementAmount settlementAmount;
    final PaymentMethodId paymentMethodId;
    final ShopId shopId;
    final AppUserId appUserId;

    public SettlementTransaction(SettlementAmount settlementAmount, PaymentMethodId paymentMethodId, ShopId shopId,
            AppUserId appUserId) {
        this.settlementAmount = settlementAmount;
        this.paymentMethodId = paymentMethodId;
        this.shopId = shopId;
        this.appUserId = appUserId;
    }



}
