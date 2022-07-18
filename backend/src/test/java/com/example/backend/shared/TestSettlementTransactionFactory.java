package com.example.backend.shared;

import com.example.backend.transactions.TransactionAmount;
import com.example.backend.transactions.appuser.AppUserId;
import com.example.backend.transactions.paymentmethod.PaymentMethodId;
import com.example.backend.transactions.campaign.Point;
import com.example.backend.transactions.settlement.SettlementTransaction;
import com.example.backend.transactions.shop.ShopId;

public class TestSettlementTransactionFactory {
    static private final TransactionAmount TRANSACTION_AMOUNT = new TransactionAmount(1000);
    static private final PaymentMethodId paymentMethodId = new PaymentMethodId("1");
    static private final ShopId shopId = new ShopId("1");
    static private final AppUserId appUserId = new AppUserId("1");
    static private final Point point = new Point(100);


    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static SettlementTransaction create() {
        return new SettlementTransaction(TRANSACTION_AMOUNT, paymentMethodId, shopId, appUserId, point);
    }

}
