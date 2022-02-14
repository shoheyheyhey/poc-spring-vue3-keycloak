package com.example.backend.infra.payment;

import static com.example.jooq.Tables.POINT_HISTORY;

import com.example.backend.domain.payment.PointHistory;
import com.example.backend.domain.payment.PointHistoryRepository;
import com.example.jooq.tables.records.PointHistoryRecord;
import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 public class PointHistoryRepositoryImpl implements PointHistoryRepository {

    public void insert(PointHistory pointHistory) {
        String userName = "root";
        String password = "root";
        String url = "jdbc:postgresql://localhost:5432/sampledb";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);

            create.insertInto(POINT_HISTORY).set(convertDomainToPointHistoryRecord(pointHistory));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PointHistoryRecord convertDomainToPointHistoryRecord(PointHistory pointHistory) {
        return new PointHistoryRecord(pointHistory.userId, pointHistory.receiptId,
                pointHistory.usagePoint.value, pointHistory.pointUsageDate.value);
    }
}
