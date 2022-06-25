package com.example.backend.transaction;


import com.example.backend.transaction.Point;
import com.example.backend.transaction.PointPaymentMethod;

/** 利用ポイント */
public class UsagePoint {
    public final Point point;
    public final PointPaymentMethod pointPaymentMethod;

    public UsagePoint(Point point, PointPaymentMethod pointPaymentMethod) {

        this.point = point;
        this.pointPaymentMethod = pointPaymentMethod;

    }

}
