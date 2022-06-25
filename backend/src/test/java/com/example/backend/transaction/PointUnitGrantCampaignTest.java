package com.example.backend.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PointUnitGrantCampaignTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        TransactionApplicableCampaign pointUnitGrantCampaign =
                TestPointUnitGrantCampaignFactory.create();

    }

    @Test void ポイント数が期待通りであること() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        TransactionApplicableCampaign pointUnitGrantCampaign =
                TestPointUnitGrantCampaignFactory.create();
        assertEquals(20, pointUnitGrantCampaign.getPoint().value);

    }

}
