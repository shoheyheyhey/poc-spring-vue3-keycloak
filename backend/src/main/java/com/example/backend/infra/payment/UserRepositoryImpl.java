package com.example.backend.infra.payment;

import static com.example.jooq.Tables.USER;

import com.example.backend.domain.payment.User;
import com.example.backend.domain.payment.UserRepository;
import com.example.backend.domain.payment.value.Point;
import com.example.jooq.tables.records.UserRecord;
import javax.validation.constraints.NotNull;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Repository @Transactional(transactionManager = "transactionManager")
public class UserRepositoryImpl implements UserRepository {

    @Autowired private DSLContext dsl;
    @NotNull
    public User findById(String userId) {

        UserRecord userRecord = dsl.selectFrom(USER).where(USER.USER_ID.eq(userId)).fetchOne();
        Assert.notNull(userRecord, "該当ユーザが存在しません");
        return convertRecordToUser(userRecord);

    }

    /**
     * データモデル→ユーザドメイン
     *
     * @param userRecord
     * @return
     */
    private User convertRecordToUser(UserRecord userRecord) {
        return new User(userRecord.getUserId(), userRecord.getUserName(),
                new Point(userRecord.getRemainingPoint()));
    }

}
