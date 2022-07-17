package com.example.backend.shared;

import com.example.backend.transactions.campaign.GrantCampaignList;

public class TestTransactionApplicableCampaignListFactory {

    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static GrantCampaignList create() {
        GrantCampaignList list = new GrantCampaignList();
        return list.add(TestPointUnitGrantCampaignFactory.create())
                .add(TestRateUnitGrantCampaignFactory.create());


    }

}
