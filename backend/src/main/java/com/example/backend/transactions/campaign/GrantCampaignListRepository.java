package com.example.backend.transactions.campaign;

import com.example.backend.transactions.settlement.SettlementAmount;
import com.example.backend.transactions.shop.ShopId;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GrantCampaignListRepository {
    GrantCampaignList findGrantCampaignList(SettlementAmount settlementAmount, ShopId shopId);
}
