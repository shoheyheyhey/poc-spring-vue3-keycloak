package com.example.backend.infra.payment;

import static com.example.jooq.Tables.POINT_HISTORY;

import com.example.backend.domain.payment.PointHistory;
import com.example.backend.domain.payment.PointHistoryRepository;
import com.example.jooq.tables.records.PointHistoryRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional(transactionManager = "transactionManager")
public class PointHistoryRepositoryImpl implements PointHistoryRepository {

    @Autowired private DSLContext dsl;

    public void insert(PointHistory pointHistory) {

        dsl.insertInto(POINT_HISTORY).set(convertDomainToPointHistoryRecord(pointHistory));

    }

    private PointHistoryRecord convertDomainToPointHistoryRecord(PointHistory pointHistory) {
        return new PointHistoryRecord(pointHistory.userId, pointHistory.receiptId,
                pointHistory.usagePoint.value, pointHistory.pointUsageDate.value);
    }
}
