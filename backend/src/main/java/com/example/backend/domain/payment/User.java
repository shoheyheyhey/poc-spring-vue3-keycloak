package com.example.backend.domain.payment;

import com.example.backend.domain.payment.value.Point;
import java.util.List;

public class User {
    public final String userId;
    public final String userName;
    public final Point remainingPoint;
    public final List<PointHistory> usagePointHistory;


    public User(String userId, String userName, Point remainingPoint,
            List<PointHistory> usagePointHistory) {
        this.userId = userId;
        this.userName = userName;
        this.remainingPoint = remainingPoint;
        this.usagePointHistory = usagePointHistory;
    }

    boolean checkMaximumPoints(Point usagePoint) {
        return this.remainingPoint.value > usagePoint.value;
    }
}
