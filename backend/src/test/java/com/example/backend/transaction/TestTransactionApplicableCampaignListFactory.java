package com.example.backend.transaction;

public class TestTransactionApplicableCampaignListFactory {

    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static TransactionApplicableCampaignList create() {
        TransactionApplicableCampaignList list = new TransactionApplicableCampaignList();
        return list.add(TestPointUnitGrantCampaignFactory.create())
                .add(TestRateUnitGrantCampaignFactory.create());


    }

}
