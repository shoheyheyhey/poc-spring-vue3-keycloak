package com.example.backend.transaction;

import com.example.backend.domain.shared.exception.DomainException;
import com.example.backend.transaction.settlement.SettlementAmount;

/** 取引アプリユーザ */
public class TransactionAppUser {
    public final AppUserId appUserId;
    public final SettlementAmount limitSettlementAmount;

    public TransactionAppUser(String appUserId, int limitSettlementAmount) {
        this.appUserId = new AppUserId(appUserId);
        this.limitSettlementAmount = new SettlementAmount(limitSettlementAmount);

    }

    /**
     * 決済上限額設定を上回る決済金額の場合ドメインエクセプション
     * @param settlementAmount
     */
    public void checkLimitSettlementAmount(SettlementAmount settlementAmount) {
        if(this.limitSettlementAmount.value < settlementAmount.value) {
            throw new DomainException("決済上限額を超えています");
        }

    }

}
