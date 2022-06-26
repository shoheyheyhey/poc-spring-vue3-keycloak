package com.example.backend.transactions.campaign;


import com.example.backend.shared.exception.DomainException;
import com.example.backend.transactions.point.Point;

/**
 * 取引適用対象キャンペーン
 */
public interface GrantCampaign {

    /**
     * 付与ポイント数を取得する
     *
     * @return
     */
    public Point getPoint();


    /**
     * 取引適用対象キャンペーンを付与単位毎に生成オブジェクトを分けて作成する
     * @param transactionAmount
     * @param grantNumber
     * @param grantUnitType
     * @return
     */
    public static GrantCampaign factoryGrantCampaign(
            int transactionAmount, int grantNumber, String grantUnitType) {
        if (GrantUnitType.RATE.getCode().equals(grantUnitType)) {
            return new RateUnitGrantCampaign(transactionAmount, grantNumber);
        }

        if (GrantUnitType.POINT.getCode().equals(grantUnitType)) {
            return new PointUnitGrantCampaign(transactionAmount, grantNumber);
        }

        throw new DomainException("不正な付与単位です。");
    }

}
