package com.example.backend.transactions.campaign;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.shared.TestRateUnitGrantCampaignFactory;
import org.junit.jupiter.api.Test;

class RateUnitGrantCampaignTest {

    @Test void 正常にインスタンス化できてポイント数が期待通りであること() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        GrantCampaign rateUnitGrantCampaign =
                TestRateUnitGrantCampaignFactory.create();
        assertEquals(30, rateUnitGrantCampaign.getPoint().value);

    }

}
