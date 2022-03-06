package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import com.example.backend.domain.shared.exception.DomainException;
import java.util.List;

public class Payment {
    public final String receiptId;
    public final PaymentAndPointDate paymentDate;
    public final Point usagePoint;
    public final Price paymentPrice;
    public final boolean grantTarget;
    public final List<PaymentDetail> paymentDetails;
    public final List<PaymentMethodDetail> paymentMethodDetails;
    public final String userId;

    public Payment(String receiptId, PaymentAndPointDate paymentDate, Point usagePoint, Price paymentPrice,
            boolean grantTarget, List<PaymentDetail> paymentDetails, List<PaymentMethodDetail> paymentMethodDetails,
            String userId) {
        if(paymentDetails.size() == 0) {
            throw new DomainException("支払詳細情報がありません。");
        }
        if(paymentMethodDetails.size() == 0) {
            throw new DomainException("支払方法詳細情報がありません。");
        }

        this.receiptId = receiptId;
        this.paymentDate = paymentDate;
        this.usagePoint = usagePoint;
        this.paymentPrice = paymentPrice;
        this.grantTarget = grantTarget;
        this.paymentDetails = paymentDetails;
        this.paymentMethodDetails = paymentMethodDetails;
        this.userId = userId;

    }

    /**
     * ポイント利用チェック
     * @return
     */
    public boolean isUsagePoint() {
        return this.usagePoint.value != 0;
    }



}
