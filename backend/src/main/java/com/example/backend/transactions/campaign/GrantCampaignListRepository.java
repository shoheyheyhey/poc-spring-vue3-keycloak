package com.example.backend.transactions.campaign;

import com.example.backend.transactions.TransactionAmount;
import com.example.backend.transactions.shop.ShopId;


public interface GrantCampaignListRepository {
    /**
     * 付与キャンペーンリスト取得
     * @param transactionAmount 取引金額
     * @param shopId 店舗ID
     * @return 付与キャンペーンリスト
     */
    GrantCampaignList findGrantCampaignList(TransactionAmount transactionAmount, ShopId shopId);
}
