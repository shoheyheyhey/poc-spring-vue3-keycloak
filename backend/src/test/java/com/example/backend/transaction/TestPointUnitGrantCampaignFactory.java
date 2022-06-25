package com.example.backend.transaction;

public class TestPointUnitGrantCampaignFactory {
    static private final int transactionAmount = 1000;
    static private final int grantPoint = 20;

    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static PointUnitGrantCampaign create() {
        return new PointUnitGrantCampaign(transactionAmount, grantPoint);
    }

}
