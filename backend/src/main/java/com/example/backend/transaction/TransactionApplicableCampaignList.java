package com.example.backend.transaction;


import java.util.ArrayList;
import java.util.List;

/**
 * 取引適用対象キャンペーンリスト
 */
public class TransactionApplicableCampaignList {
    private final List<TransactionApplicableCampaign> adjustmentTransactionApplicableCampaigns;

    public TransactionApplicableCampaignList() {
        this.adjustmentTransactionApplicableCampaigns = new ArrayList<>();
    }

    private TransactionApplicableCampaignList(
            List<TransactionApplicableCampaign> adjustmentTransactionApplicableCampaigns) {
        this.adjustmentTransactionApplicableCampaigns = adjustmentTransactionApplicableCampaigns;

    }

    /**
     * 取引適用対象キャンペーンを追加する
     *
     * @param newTransactionApplicableCampaign 追加したいキャンペーン
     * @return キャンペーン追加後の取引適用対象キャンペーンリスト
     */
    public TransactionApplicableCampaignList add(
            TransactionApplicableCampaign newTransactionApplicableCampaign) {
        final List<TransactionApplicableCampaign> adding =
                new ArrayList<>(this.adjustmentTransactionApplicableCampaigns);
        adding.add(newTransactionApplicableCampaign);
        return new TransactionApplicableCampaignList(adding);
    }

    /**
     * 取引適用対象キャンペーンの合計付与ポイント数を取得する
     *
     * @return 取引適用対象キャンペーンリストの合計付与ポイント数
     */
    public Point getTotalPoint() {
        return new Point(this.adjustmentTransactionApplicableCampaigns.stream().mapToInt(
                        transactionApplicableCampaign -> transactionApplicableCampaign.getPoint().value)
                .sum());
    }
}
