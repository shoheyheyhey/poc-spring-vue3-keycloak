package com.example.backend.transactions.campaign;


/**
 * ポイント単位付与キャンペーン
 */
public class PointUnitGrantCampaign implements GrantCampaign {

    private final Point grantPoint;

    protected PointUnitGrantCampaign( int grantPoint) {
        this.grantPoint = new Point(grantPoint);
    }

    /** {@inheritDoc} */
    @Override public Point getPoint() {
        return this.grantPoint;
    }

}
