package com.example.backend.transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.transactions.campaign.GrantCampaignList;
import org.junit.jupiter.api.Test;

class GrantCampaignListTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        GrantCampaignList transactionApplicableCampaigns =
                TestTransactionApplicableCampaignListFactory.create();

    }

    @Test void 合計ポイント数が期待通りであること() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        GrantCampaignList transactionApplicableCampaigns =
                TestTransactionApplicableCampaignListFactory.create();
        assertEquals(50, transactionApplicableCampaigns.getTotalPoint().value);

    }

}
