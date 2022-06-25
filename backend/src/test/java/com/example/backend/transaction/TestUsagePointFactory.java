package com.example.backend.transaction;

public class TestUsagePointFactory {
    static private final com.example.backend.transaction.Point point =
            new com.example.backend.transaction.Point(100);


    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static UsagePoint create() {
        return new UsagePoint(point, TestPointPaymentMethodFactory.create());
    }

    public static UsagePoint create(Point point) {
        return new UsagePoint(point, TestPointPaymentMethodFactory.create());
    }

    public static UsagePoint create(PointPaymentMethod pointPaymentMethod) {
        return new UsagePoint(point, pointPaymentMethod);
    }

}
