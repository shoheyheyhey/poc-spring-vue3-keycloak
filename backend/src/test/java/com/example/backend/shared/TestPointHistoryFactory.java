package com.example.backend.shared;

import com.example.backend.domain.payment.PointHistory;
import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import java.time.LocalDate;

public class TestPointHistoryFactory {
    static private final String userId = "0000000001";
    static private final String receiptId = "0000000001";
    static private final PaymentAndPointDate pointUsageDate =
            new PaymentAndPointDate(LocalDate.of(2021, 1, 1));
    static private final Point usagePoint = new Point(200);

    /**
     * デフォルト設定でポイント履歴作成
     *
     * @return
     */
    public static PointHistory create() {
        return pointHistoryCreate(userId, receiptId, usagePoint, pointUsageDate);
    }

    /**
     * ユーザID個別設定でポイント履歴作成
     *
     * @return
     */
    public static PointHistory create(String userId) {
        return pointHistoryCreate(userId, receiptId, usagePoint, pointUsageDate);
    }

    /**
     * 利用ポイント個別設定でポイント履歴作成
     *
     * @return
     */
    public static PointHistory create(Point usagePoint) {
        return pointHistoryCreate(userId, receiptId, usagePoint, pointUsageDate);
    }


    private static PointHistory pointHistoryCreate(String userId, String receiptId,
            Point usagePoint, PaymentAndPointDate pointUsageDate) {
        return new PointHistory(userId, receiptId, usagePoint, pointUsageDate);
    }

}
