package com.example.backend.transactions.settlement;

import lombok.Builder;
import lombok.Data;

@Data @Builder public class SettlementCreateParam {
    /**
     * 決済金額
     */
    private int settlementAmount;
    /**
     * 決済手段ID
     */
    private String paymentMethodId;
    /**
     * アプリユーザID
     */
    private String appUserId;
    /**
     * 店舗ID
     */
    private String shopId;

}
