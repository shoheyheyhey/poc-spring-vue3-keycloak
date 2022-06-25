package com.example.backend.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RateUnitGrantCampaignTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        TransactionApplicableCampaign rateUnitGrantCampaign =
                TestRateUnitGrantCampaignFactory.create();

    }

    @Test void ポイント数が期待通りであること() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        TransactionApplicableCampaign rateUnitGrantCampaign =
                TestRateUnitGrantCampaignFactory.create();
        assertEquals(30, rateUnitGrantCampaign.getPoint().value);

    }

}
