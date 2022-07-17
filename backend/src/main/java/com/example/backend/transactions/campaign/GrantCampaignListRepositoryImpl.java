package com.example.backend.transactions.campaign;

import static com.example.jooq.Tables.CAMPAIGN;
import static com.example.jooq.Tables.CAMPAIGN_SHOP_CONDITION;
import static com.example.jooq.Tables.CAMPAIGN_TRANSACTION_AMOUNT_CONDITION;

import com.example.backend.transactions.TransactionAmount;
import com.example.backend.transactions.shop.ShopId;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GrantCampaignListRepositoryImpl implements GrantCampaignListRepository {

    @Autowired private DSLContext dsl;

    /** {@inheritDoc} */
    public GrantCampaignList findGrantCampaignList(TransactionAmount transactionAmount,
            ShopId shopId) {
        GrantCampaignList grantCampaignList = new GrantCampaignList();
        List<Record2<String, Integer>> records = dsl.select(CAMPAIGN.GRANT_UNIT_TYPE,
                        CAMPAIGN_TRANSACTION_AMOUNT_CONDITION.GRANT_NUMBER).from(CAMPAIGN)
                .innerJoin(CAMPAIGN_SHOP_CONDITION)
                .on(CAMPAIGN.CAMPAIGN_ID.eq(CAMPAIGN_SHOP_CONDITION.CAMPAIGN_ID))
                .innerJoin(CAMPAIGN_TRANSACTION_AMOUNT_CONDITION)
                .on(CAMPAIGN.CAMPAIGN_ID.eq(CAMPAIGN_TRANSACTION_AMOUNT_CONDITION.CAMPAIGN_ID))
                .where(CAMPAIGN_SHOP_CONDITION.SHOP_ID.eq(shopId.value))
                .and(CAMPAIGN_TRANSACTION_AMOUNT_CONDITION.MINIMUM_TRANSACTION_AMOUNT.le(
                        transactionAmount.value))
                .and(CAMPAIGN_TRANSACTION_AMOUNT_CONDITION.MAXIMUM_TRANSACTION_AMOUNT.ge(
                        transactionAmount.value)).stream().toList();

        if (records == null || records.size() == 0) {
            return grantCampaignList;
        }

        for (Record2<String, Integer> record : records) {
            grantCampaignList = grantCampaignList.add(
                    GrantCampaign.factoryGrantCampaign(transactionAmount.value,
                            record.get(CAMPAIGN_TRANSACTION_AMOUNT_CONDITION.GRANT_NUMBER),
                            record.get(CAMPAIGN.GRANT_UNIT_TYPE)));
        }

        return grantCampaignList;
    }
}
