package com.example.backend.transactions.appuser;

import com.example.backend.shared.exception.DomainException;
import com.example.backend.transactions.TransactionAmount;

/** 取引アプリユーザ */
public class TransactionAppUser {
    final AppUserId appUserId;
    final TransactionAmount limitTransactionAmount;

    public TransactionAppUser(String appUserId, int limitSettlementAmount) {
        this.appUserId = new AppUserId(appUserId);
        this.limitTransactionAmount = new TransactionAmount(limitSettlementAmount);

    }

    /**
     * 【決済上限額チェック】<br>
     * 決済上限額設定を上回る取引金額の場合ドメインエクセプション
     * @param transactionAmount 取引金額
     */
    public void checkLimitSettlementAmount(TransactionAmount transactionAmount) {
        if(this.limitTransactionAmount.value < transactionAmount.value) {
            throw new DomainException("決済上限額を超えています");
        }

    }

}
