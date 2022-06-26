package com.example.backend.transactions.campaign;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.shared.TestSupport;
import com.example.backend.transactions.settlement.SettlementAmount;
import com.example.backend.transactions.shop.ShopId;
import com.example.jooq.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest @Import({DataSourceConfig.class}) @Transactional
public class GrantCampaignRepositoryTest extends TestSupport {
    @Autowired private GrantCampaignListRepository grantCampaignListRepository;

    @Test public void 取得した付与キャンペーンの合計ポイント数が期待通り() {
        // given(前提条件)：

        // when(操作)：
        ShopId shopId = new ShopId("1");
        SettlementAmount settlementAmount = new SettlementAmount(1000);
        GrantCampaignList grantCampaignList =
                grantCampaignListRepository.findGrantCampaignList(settlementAmount, shopId);

        // then(期待する結果):
        assertEquals(120, grantCampaignList.getTotalPoint().value);

    }
}
