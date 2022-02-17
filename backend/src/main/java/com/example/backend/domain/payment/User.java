package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Point;
import java.util.List;

public class User {
    public final String userId;
    public final String userName;
    public final Point remainingPoint;


    public User(String userId, String userName, Point remainingPoint) {
        this.userId = userId;
        this.userName = userName;
        this.remainingPoint = remainingPoint;
    }

    boolean checkMaximumPoints(Point usagePoint) {
        return this.remainingPoint.value > usagePoint.value;
    }
}
