package com.example.backend.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TransactionApplicableCampaignListTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        TransactionApplicableCampaignList transactionApplicableCampaigns =
                TestTransactionApplicableCampaignListFactory.create();

    }

    @Test void 合計ポイント数が期待通りであること() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        TransactionApplicableCampaignList transactionApplicableCampaigns =
                TestTransactionApplicableCampaignListFactory.create();
        assertEquals(50, transactionApplicableCampaigns.getTotalPoint().value);

    }

}
