package com.example.backend.transactions.campaign;


import com.example.backend.shared.exception.DomainException;

/**
 * 付与キャンペーン
 */
public interface GrantCampaign {

    /**
     * 付与ポイント数を取得する
     *
     * @return 付与ポイント
     */
    Point getPoint();

    /**
     * 取引適用対象キャンペーンを付与単位毎に生成オブジェクトを分けて作成する
     * @param transactionAmount 取引金額
     * @param grantNumber 付与数
     * @param grantUnitType 付与単位
     * @return 付与キャンペーン
     */
    static GrantCampaign factoryGrantCampaign(
            int transactionAmount, int grantNumber, String grantUnitType) {
        if (GrantUnitType.RATE.getCode().equals(grantUnitType)) {
            return new RateUnitGrantCampaign(transactionAmount, grantNumber);
        }

        if (GrantUnitType.POINT.getCode().equals(grantUnitType)) {
            return new PointUnitGrantCampaign(grantNumber);
        }

        throw new DomainException("不正な付与単位です。");
    }

}
