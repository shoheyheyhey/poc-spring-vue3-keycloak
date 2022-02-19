package com.example.backend.usecase.payment;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data @Builder public class PaymentCreateParam {
    /**
     * レシートID
     */
    private String receiptId;
    /**
     * 支払日
     */
    private LocalDate paymentDate;
    /**
     * 利用ポイント
     */
    private int usagePoint;
    /**
     * 支払い金額
     */
    private int paymentPrice;
    /**
     * ポイント付与対象
     */
    private boolean grantTarget;
    /**
     * 支払い明細
     */
    public final List<PaymentDetailParam> paymentDetails;
    /**
     * 支払い方法明細
     */
    public final List<PaymentMethodDetailParam> paymentMethodDetails;
    /**
     * ユーザID
     */
    private String userId;


    /**
     * 支払い明細
     */
    @Data @Builder public static class PaymentDetailParam {
        /**
         * 商品名
         */
        private String itemName;
        /**
         * 商品単価
         */
        private int unitPrice;
    }


    /**
     * 支払い方法明細
     */
    @Data @Builder public static class PaymentMethodDetailParam {
        /**
         * 支払い方法名
         */
        private String paymentMethodName;
        /**
         * 支払い金額
         */
        private int paymentAmount;
    }
}
