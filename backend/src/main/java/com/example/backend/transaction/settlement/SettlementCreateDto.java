package com.example.backend.transaction.settlement;

import lombok.Builder;
import lombok.Data;

@Builder @Data public class SettlementCreateDto {
    /**
     * レシートID
     */
    private String receiptId;

}
