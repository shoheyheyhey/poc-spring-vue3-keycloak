package com.example.backend.transactions.settlement;

import lombok.Builder;
import lombok.Data;

@Builder @Data public class SettlementCreateDto {
    /**
     * 取引ID
     */
    private String transactionId;

}
