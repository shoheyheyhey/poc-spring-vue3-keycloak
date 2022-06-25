package com.example.backend.transaction;


/**
 * ポイント単位付与キャンペーン
 */
public class PointUnitGrantCampaign implements TransactionApplicableCampaign {

    private final int transactionAmount;
    private final Point grantPoint;

    PointUnitGrantCampaign(int transactionAmount, int grantPoint) {
        this.transactionAmount = transactionAmount;
        this.grantPoint = new Point(grantPoint);
    }

    @Override public Point getPoint() {
        return this.grantPoint;
    }

}
