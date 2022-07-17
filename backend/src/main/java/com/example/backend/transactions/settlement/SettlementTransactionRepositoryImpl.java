package com.example.backend.transactions.settlement;

import static com.example.jooq.Tables.GRANT_POINT;
import static com.example.jooq.Tables.TRANSACTIONS;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional(transactionManager = "transactionManager")
public class SettlementTransactionRepositoryImpl implements SettlementTransactionRepository {

    @Autowired private DSLContext dsl;

    public void insert(SettlementTransaction settlementTransaction) {
        dsl.insertInto(TRANSACTIONS, TRANSACTIONS.TRANSACTION_ID, TRANSACTIONS.APP_USER_ID,
                        TRANSACTIONS.TRANSACTION_AMOUNT, TRANSACTIONS.PAYMENT_METHOD_ID,
                        TRANSACTIONS.SHOP_ID).values(settlementTransaction.transactionId.value,
                        settlementTransaction.appUserId.value,
                        settlementTransaction.transactionAmount.value,
                        settlementTransaction.paymentMethodId.value, settlementTransaction.shopId.value)
                .execute();

        dsl.insertInto(GRANT_POINT, GRANT_POINT.TRANSACTION_ID, GRANT_POINT.APP_USER_ID,
                        GRANT_POINT.POINT)
                .values(settlementTransaction.transactionId.value, settlementTransaction.appUserId.value,
                        settlementTransaction.grantPoint.value).execute();
    }
}
