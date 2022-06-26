package com.example.backend.transactions;

import com.example.backend.transactions.campaign.GrantCampaign;
import com.example.backend.transactions.campaign.GrantUnitType;
import com.example.backend.transactions.campaign.PointUnitGrantCampaign;

public class TestPointUnitGrantCampaignFactory {
    static private final int transactionAmount = 1000;
    static private final int grantPoint = 20;

    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static PointUnitGrantCampaign create() {
        return (PointUnitGrantCampaign) GrantCampaign.factoryGrantCampaign(transactionAmount,
                grantPoint, GrantUnitType.POINT.getCode());
    }

}
