package com.example.backend.transactions.settlement;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data @Builder public class SettlementCreateReq {
    /**
     * 決済金額
     */
    @NotBlank @Min(0) @Max(1000000) private int settlementAmount;
    /**
     * 決済手段ID
     */
    @NotBlank private String paymentMethodId;
    /**
     * アプリユーザID
     */
    @NotBlank private String appUserId;
    /**
     * 店舗ID
     */
    @NotBlank private String shopId;
}
