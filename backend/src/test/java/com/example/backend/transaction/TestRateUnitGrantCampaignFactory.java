package com.example.backend.transaction;

public class TestRateUnitGrantCampaignFactory {
    static private final int transactionAmount = 1000;
    static private final int grantRate = 3;

    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static RateUnitGrantCampaign create() {
        return new RateUnitGrantCampaign(transactionAmount, grantRate);
    }

}
