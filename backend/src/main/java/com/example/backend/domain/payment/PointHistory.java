package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import lombok.Builder;

@Builder
public class PointHistory {
    public final String userId;
    public final String receiptId;
    public final Point usagePoint;
    public final PaymentAndPointDate pointUsageDate;

    public PointHistory(String userId, String receiptId, Point usagePoint,
            PaymentAndPointDate pointUsageDate) {
        this.userId = userId;
        this.receiptId = receiptId;
        this.usagePoint = usagePoint; // 0ポイントはPoint側でチェックされるため記録されることはない
        this.pointUsageDate = pointUsageDate;
    }

}
