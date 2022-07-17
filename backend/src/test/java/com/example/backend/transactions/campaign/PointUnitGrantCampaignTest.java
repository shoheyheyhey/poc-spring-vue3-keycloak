package com.example.backend.transactions.campaign;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.shared.TestPointUnitGrantCampaignFactory;
import org.junit.jupiter.api.Test;

class PointUnitGrantCampaignTest {

    @Test void 正常にインスタンス化できてポイント数が期待通りであること() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        GrantCampaign pointUnitGrantCampaign =
                TestPointUnitGrantCampaignFactory.create();
        assertEquals(20, pointUnitGrantCampaign.getPoint().value);

    }

}
