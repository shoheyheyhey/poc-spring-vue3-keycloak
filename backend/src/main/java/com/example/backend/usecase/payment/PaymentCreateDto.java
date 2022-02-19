package com.example.backend.usecase.payment;

import lombok.Builder;
import lombok.Data;

@Builder @Data public class PaymentCreateDto {
    /**
     * レシートID
     */
    private String receiptId;

}
