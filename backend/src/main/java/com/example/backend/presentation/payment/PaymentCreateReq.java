package com.example.backend.presentation.payment;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data @Builder public class PaymentCreateReq {
    /**
     * レシートID
     */
    @NotBlank @Size(min = 10, max = 10) private String receiptId;
    /**
     * 支払日
     */
    @NotBlank private LocalDate paymentDate;
    /**
     * 利用ポイント
     */
    @NotBlank @Min(-10000) @Max(10000) private int usagePoint;
    /**
     * 支払い金額
     */
    @NotBlank @Min(-1000000) @Max(1000000) private int paymentPrice;
    /**
     * ポイント付与対象
     */
    @NotBlank private boolean grantTarget;
    /**
     * 支払い明細
     */
    @NotBlank @Size(min = 1, max = 100) public final List<PaymentDetailReq> paymentDetails;
    /**
     * 支払い方法明細
     */
    @NotBlank @Size(min = 1, max = 3) public final List<PaymentMethodDetailReq> paymentMethodDetails;
    /**
     * ユーザID
     */
    @NotBlank private String userId;

    /**
     * 支払い明細
     */
    @Data @Builder public static class PaymentDetailReq {
        /**
         * 商品名
         */
        @NotBlank private String itemName;
        /**
         * 商品単価
         */
        @NotBlank @Min(-1000000) @Max(1000000) private int unitPrice;
    }

    /**
     * 支払い方法明細
     */
    @Data @Builder public static class PaymentMethodDetailReq {
        /**
         * 支払い方法名
         */
        @NotBlank private String paymentMethodName;
        /**
         * 支払い金額
         */
        @NotBlank @Min(-1000000) @Max(1000000) private int paymentAmount;
    }
}
