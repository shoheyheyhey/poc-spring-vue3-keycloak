package com.example.backend.shared;

import com.example.backend.transactions.appuser.TransactionAppUser;


public class TestTransactionAppUserFactory {
    static private final int limitTransactionAmount = 10000;
    static private final String appUserId = "1";


    /**
     * デフォルト設定で作成
     *
     * @return
     */
    public static TransactionAppUser create() {
        return new TransactionAppUser(appUserId, limitTransactionAmount);
    }

}
