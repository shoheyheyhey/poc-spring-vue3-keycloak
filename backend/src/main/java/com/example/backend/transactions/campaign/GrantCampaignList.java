package com.example.backend.transactions.campaign;


import java.util.ArrayList;
import java.util.List;

/**
 * 付与キャンペーンリスト
 */
public class GrantCampaignList {
    private final List<GrantCampaign> grantCampaigns;

    public GrantCampaignList() {
        this.grantCampaigns = new ArrayList<>();
    }

    private GrantCampaignList(
            List<GrantCampaign> grantCampaigns) {
        this.grantCampaigns = grantCampaigns;
    }

    /**
     * 付与キャンペーンを追加する(5より大きい数のキャンペーンを紐付かせないようにする)
     * 付与キャンペーンを追加する際の業務ロジックはここに条件を追加する
     * @param newGrantCampaign 追加したいキャンペーン
     * @return キャンペーン追加後の取引適用対象キャンペーンリスト
     */
    public GrantCampaignList add(
            GrantCampaign newGrantCampaign) {
        final List<GrantCampaign> adding =
                new ArrayList<>(this.grantCampaigns);

        if (adding.size() < 5) {
            adding.add(newGrantCampaign);
        }

        return new GrantCampaignList(adding);
    }

    /**
     * 取引適用対象キャンペーンの合計付与ポイント数を取得する
     *
     * @return 取引適用対象キャンペーンリストの合計付与ポイント数
     */
    public Point getTotalPoint() {
        return new Point(this.grantCampaigns.stream().mapToInt(
                        grantCampaign -> grantCampaign.getPoint().value)
                .sum());
    }
}
