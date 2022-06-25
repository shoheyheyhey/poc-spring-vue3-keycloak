package com.example.backend.transaction.settlement;

import com.example.backend.transaction.AppUserId;
import com.example.backend.transaction.PaymentMethodId;
import com.example.backend.transaction.ShopId;
import com.example.backend.transaction.TransactionId;
import com.example.backend.transaction.UsagePoint;

/**
 * 決済取引
 */
public class SettlementTransaction {
    public final TransactionId transactionId = new TransactionId();
    public final SettlementAmount settlementAmount;
    public final PaymentMethodId paymentMethodId;
    public final ShopId shopId;
    public final AppUserId appUserId;
    public final UsagePoint usagePoint;

    public SettlementTransaction(int settlementAmount, String paymentMethodId, String shopId,
            String appUserId, UsagePoint usagePoint) {
        this.settlementAmount = new SettlementAmount(settlementAmount);
        this.paymentMethodId = new PaymentMethodId(paymentMethodId);
        this.shopId = new ShopId(shopId);
        this.appUserId = new AppUserId(appUserId);
        this.usagePoint = usagePoint;
    }



}
