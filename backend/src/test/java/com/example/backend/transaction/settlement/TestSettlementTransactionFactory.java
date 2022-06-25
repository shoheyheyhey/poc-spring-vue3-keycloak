package com.example.backend.transaction.settlement;

import com.example.backend.transaction.TestUsagePointFactory;

public class TestSettlementTransactionFactory {
    static private final int settlementAmount = 1000;
    static private final String paymentMethodId = "1";
    static private final String shopId = "1";
    static private final String appUserId = "1";



    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static SettlementTransaction create() {
        return new SettlementTransaction(settlementAmount, paymentMethodId, shopId, appUserId,
                TestUsagePointFactory.create());
    }

}
