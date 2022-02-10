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
    public final List<PaymentMethod> paymentMethods;
    public final User user;

    Payment(String receiptId, PaymentAndPointDate paymentDate, Point usagePoint, Price paymentPrice,
            boolean grantTarget, List<PaymentDetail> paymentDetails, List<PaymentMethod> paymentMethods,
            User user) {
        this.receiptId = receiptId;
        this.paymentDate = paymentDate;
        this.usagePoint = usagePoint;
        this.paymentPrice = paymentPrice;
        this.grantTarget = grantTarget;
        this.paymentDetails = paymentDetails;
        this.paymentMethods = paymentMethods;
        this.user = user;

        if(!user.checkMaximumPoints(usagePoint)) {
            throw new DomainException("ポイント残高以上ポイントは利用できません");
        }


    }



}
