package com.example.backend.transactions.settlement;

import com.example.backend.transactions.TransactionAmount;
import com.example.backend.transactions.TransactionId;
import com.example.backend.transactions.appuser.AppUserId;
import com.example.backend.transactions.paymentmethod.PaymentMethodId;
import com.example.backend.transactions.campaign.Point;
import com.example.backend.transactions.shop.ShopId;

/**
 * 決済取引
 */
public class SettlementTransaction {
    public final TransactionId transactionId = new TransactionId();
    final TransactionAmount transactionAmount;
    final PaymentMethodId paymentMethodId;
    final ShopId shopId;
    final AppUserId appUserId;
    final Point grantPoint;

    public SettlementTransaction(TransactionAmount transactionAmount,
            PaymentMethodId paymentMethodId, ShopId shopId, AppUserId appUserId, Point grantPoint) {
        this.transactionAmount = transactionAmount;
        this.paymentMethodId = paymentMethodId;
        this.shopId = shopId;
        this.appUserId = appUserId;
        this.grantPoint = grantPoint;
    }



}
