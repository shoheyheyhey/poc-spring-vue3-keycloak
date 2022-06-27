package com.example.backend.transactions.point;

import com.example.backend.transactions.TransactionId;
import com.example.backend.transactions.appuser.AppUserId;
import com.example.backend.transactions.campaign.GrantCampaignList;

public class GrantPoint {
    final Point point;
    final AppUserId appUserId;
    final TransactionId transactionId;

    public GrantPoint(GrantCampaignList grantCampaignList, AppUserId appUserId,
            TransactionId transactionId) {
        this.point = grantCampaignList.getTotalPoint();
        this.appUserId = appUserId;
        this.transactionId = transactionId;
    }
}
