package com.example.backend.transactions.campaign;


import com.example.backend.transactions.point.Point;

/**
 * 率単位付与キャンペーン
 */
public class RateUnitGrantCampaign implements GrantCampaign {

    private final int transactionAmount;
    private final int grantRate;

    protected RateUnitGrantCampaign(int transactionAmount, int grantRate) {
        this.transactionAmount = transactionAmount;
        this.grantRate = grantRate;
    }

    @Override public Point getPoint() {
        return new Point((int) Math.floor(this.transactionAmount * 0.01 * grantRate));
    }

}
