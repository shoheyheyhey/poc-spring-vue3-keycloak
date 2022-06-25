package com.example.backend.transaction;


import com.example.backend.domain.shared.exception.DomainException;
import com.example.backend.share.GrantUnitType;

/**
 * 取引適用対象キャンペーン
 */
public interface TransactionApplicableCampaign {

    /**
     * 付与ポイント数を取得する
     *
     * @return
     */
    public Point getPoint();


    /**
     * 取引適用対象キャンペーンを付与単位毎に生成オブジェクトを分けて作成する
     * @param transactionAmount
     * @param grantPoint
     * @param grantRate
     * @param grantUnitType
     * @return
     */
    public static TransactionApplicableCampaign factoryTransactionApplicableCampaign(
            int transactionAmount, int grantPoint, int grantRate, String grantUnitType) {
        if (GrantUnitType.PERCENT.getCode().equals(grantUnitType)) {
            return new RateUnitGrantCampaign(transactionAmount, grantRate);
        }

        if (GrantUnitType.POINT.getCode().equals(grantUnitType)) {
            return new PointUnitGrantCampaign(transactionAmount, grantPoint);
        }

        throw new DomainException("不正な付与単位です。");
    }

}
