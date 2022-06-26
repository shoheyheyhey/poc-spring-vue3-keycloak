package com.example.backend.transactions.settlement;

import com.example.backend.transactions.appuser.AppUserId;
import com.example.backend.transactions.paymentmethod.PaymentMethodId;
import com.example.backend.transactions.shop.ShopId;

public class TestSettlementTransactionFactory {
    static private final SettlementAmount settlementAmount = new SettlementAmount(1000);
    static private final PaymentMethodId paymentMethodId = new PaymentMethodId("1");
    static private final ShopId shopId = new ShopId("1");
    static private final AppUserId appUserId = new AppUserId("1");


    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static SettlementTransaction create() {
        return new SettlementTransaction(settlementAmount, paymentMethodId, shopId, appUserId);
    }

}
