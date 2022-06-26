package com.example.backend.transactions.campaign;


import com.example.backend.transactions.point.Point;

/**
 * ポイント単位付与キャンペーン
 */
public class PointUnitGrantCampaign implements GrantCampaign {

    private final int transactionAmount;
    private final Point grantPoint;

    protected PointUnitGrantCampaign(int transactionAmount, int grantPoint) {
        this.transactionAmount = transactionAmount;
        this.grantPoint = new Point(grantPoint);
    }

    @Override public Point getPoint() {
        return this.grantPoint;
    }

}
