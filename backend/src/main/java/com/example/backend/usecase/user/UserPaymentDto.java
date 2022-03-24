package com.example.backend.usecase.user;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Builder @Data public class UserPaymentDto {
    /** 支払日 */
    private LocalDate paymentDate;
    /** 利用ポイント */
    private int usagePoint;
    /** 支払い金額 */
    private int paymentPrice;

}
