package com.example.backend.transactions.appuser;

import static com.example.jooq.Tables.APP_USER;

import com.example.backend.shared.exception.InfraException;
import com.example.jooq.tables.records.AppUserRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionAppUserRepositoryImpl implements TransactionAppUserRepository {

    @Autowired private DSLContext dsl;

    public TransactionAppUser findById(AppUserId appUserId) {
        AppUserRecord appUserRecord =
                dsl.selectFrom(APP_USER).where(APP_USER.APP_USER_ID.eq(appUserId.value)).fetchOne();
        if (appUserRecord == null) {
            throw new InfraException("アプリユーザが存在しません");
        }
        return convertDomainObject(appUserRecord);
    }


    /**
     * 取引アプリユーザオブジェクトを生成する
     *
     * @param record アプリユーザレコード情報
     * @return 取引アプリユーザドメインオブジェクト
     */
    private TransactionAppUser convertDomainObject(AppUserRecord record) {
        return new TransactionAppUser(record.getAppUserId(), record.getSettlementUpperLimit());
    }
}
