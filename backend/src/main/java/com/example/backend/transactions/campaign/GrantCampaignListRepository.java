package com.example.backend.transactions.campaign;

import com.example.backend.transactions.TransactionAmount;
import com.example.backend.transactions.shop.ShopId;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GrantCampaignListRepository {
    GrantCampaignList findGrantCampaignList(TransactionAmount transactionAmount, ShopId shopId);
}
