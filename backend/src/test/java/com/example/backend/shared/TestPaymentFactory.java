package com.example.backend.shared;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPaymentFactory {
    static private final String receiptId = "0000000001";
    static private final PaymentAndPointDate paymentDate =
            new PaymentAndPointDate(LocalDate.of(2021, 1, 1));
    static private final Price paymentPrice = new Price(6000);
    static private final Point usagePoint = new Point(200);
    static private final boolean grantTarget = true;
    static private final List<PaymentDetail> paymentDetails = new ArrayList<>(Arrays.asList(
            new PaymentDetail("〇〇シャンプー", new Price(2000))));
    static private final List<PaymentMethodDetail> paymentMethodDetails = new ArrayList<>(
            Arrays.asList(new PaymentMethodDetail("クレジットカード",new Price(1800))));
    static private final String userId = "0000000001";

    /**
     * デフォルト設定で支払作成
     *
     * @return
     */
    public static Payment create() {
        return paymentCreate(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                paymentDetails, paymentMethodDetails, userId);
    }

    /**
     * レシートID個別設定で支払作成
     *
     * @return
     */
    public static Payment create(String receiptId) {
        return paymentCreate(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                paymentDetails, paymentMethodDetails, userId);
    }

    /**
     * 利用ポイント数個別設定で支払作成
     *
     * @return
     */
    public static Payment create(Point usagePoint) {
        return paymentCreate(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                paymentDetails, paymentMethodDetails, userId);
    }

    /**
     * 支払金額個別設定で支払作成
     *
     * @param paymentPrice
     * @return
     */
    public static Payment create(Price paymentPrice) {
        return paymentCreate(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                paymentDetails, paymentMethodDetails, userId);
    }


    /**
     * 支払詳細個別設定で支払作成, 決済手段明細個別設定で支払作成
     *
     * @param paymentDetails
     */
    public static Payment create(List<PaymentDetail> paymentDetails, List<PaymentMethodDetail> paymentMethodDetails) {
        return paymentCreate(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                paymentDetails, paymentMethodDetails, userId);
    }


    private static Payment paymentCreate(String receiptId, PaymentAndPointDate paymentDate,
            Point usagePoint, Price paymentPrice, boolean grantTarget,
            List<PaymentDetail> paymentDetails, List<PaymentMethodDetail> paymentMethodDetails,
            String userId) {
        return new Payment(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                paymentDetails, paymentMethodDetails, userId);
    }

}
