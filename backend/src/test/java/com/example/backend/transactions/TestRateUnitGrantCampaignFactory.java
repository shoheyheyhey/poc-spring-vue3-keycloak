package com.example.backend.transactions;

import com.example.backend.transactions.campaign.GrantCampaign;
import com.example.backend.transactions.campaign.GrantUnitType;
import com.example.backend.transactions.campaign.RateUnitGrantCampaign;

public class TestRateUnitGrantCampaignFactory {
    static private final int transactionAmount = 1000;
    static private final int grantRate = 3;

    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static RateUnitGrantCampaign create() {
        return (RateUnitGrantCampaign) GrantCampaign.factoryGrantCampaign(transactionAmount,
                grantRate, GrantUnitType.RATE.getCode());
    }

}
