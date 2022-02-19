package com.example.backend.presentation.payment;

import lombok.Builder;
import lombok.Data;

@Builder @Data public class PaymentCreateRes {
    /**
     * レシートID
     */
    private String receiptId;

}
