package com.example.backend.transaction;


/**
 * 率単位付与キャンペーン
 */
public class RateUnitGrantCampaign implements TransactionApplicableCampaign {

    private final int transactionAmount;
    private final int grantRate;

    RateUnitGrantCampaign(int transactionAmount, int grantRate) {
        this.transactionAmount = transactionAmount;
        this.grantRate = grantRate;
    }

    @Override public Point getPoint() {
        return new Point((int) Math.floor(this.transactionAmount * 0.01 * grantRate));
    }

}
