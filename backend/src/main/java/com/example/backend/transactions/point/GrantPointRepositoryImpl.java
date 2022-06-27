package com.example.backend.transactions.point;

import static com.example.jooq.Tables.GRANT_POINT;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional(transactionManager = "transactionManager")
public class GrantPointRepositoryImpl implements GrantPointRepository {

    @Autowired private DSLContext dsl;

    public void insert(GrantPoint grantPoint) {
        dsl.insertInto(GRANT_POINT, GRANT_POINT.TRANSACTION_ID, GRANT_POINT.APP_USER_ID,
                        GRANT_POINT.POINT)
                .values(grantPoint.transactionId.value, grantPoint.appUserId.value,
                        grantPoint.point.value).execute();
    }
}
