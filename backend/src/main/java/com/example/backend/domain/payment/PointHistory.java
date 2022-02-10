package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;

public class PointHistory {
    public final Point usagePoint;
    public final PaymentAndPointDate pointUsageDate;

    PointHistory(Point usagePoint, PaymentAndPointDate pointUsageDate) {
        this.usagePoint = usagePoint;
        this.pointUsageDate = pointUsageDate;
    }

}
