package com.example.backend.infra.user;

import static com.example.jooq.Tables.PAYMENT;
import static com.example.jooq.Tables.USER;

import com.example.backend.usecase.user.UserAndPaymentDto;
import com.example.backend.usecase.user.UserAndPaymentDtoQueryService;
import com.example.backend.usecase.user.UserPaymentDto;
import com.example.jooq.tables.records.PaymentRecord;
import com.example.jooq.tables.records.UserRecord;
import java.util.List;
import java.util.stream.Collectors;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional(transactionManager = "transactionManager")
public class UserAndPaymentDtoQueryServiceImpl implements UserAndPaymentDtoQueryService {

    @Autowired private DSLContext dsl;

    public UserAndPaymentDto fetchList(String userId) {
        UserRecord userRecord = dsl.selectFrom(USER).where(USER.USER_ID.eq(userId)).fetchOne();
        List<PaymentRecord> paymentRecords =
                dsl.selectFrom(PAYMENT).where(PAYMENT.USER_ID.eq(userId)).fetch().stream()
                        .collect(Collectors.toList());

        return convertRecordToUserAndPaymentDto(userRecord, paymentRecords);


    }

    private UserAndPaymentDto convertRecordToUserAndPaymentDto(UserRecord userRecord,
            List<PaymentRecord> paymentRecords) {
        List<UserPaymentDto> userPaymentDtos = paymentRecords.stream()
                .map(paymentRecord -> convertRecordToUserPaymentDto(paymentRecord))
                .collect(Collectors.toList());
        return UserAndPaymentDto.builder().userName(userRecord.getUserName())
                .remainingPoint(userRecord.getRemainingPoint()).userPaymentDtos(userPaymentDtos)
                .build();

    }

    private UserPaymentDto convertRecordToUserPaymentDto(PaymentRecord paymentRecord) {
        return UserPaymentDto.builder().paymentDate(paymentRecord.getPaymentDate())
                .paymentPrice(paymentRecord.getPaymentPrice())
                .usagePoint(paymentRecord.getUsagePoint()).build();
    }
}
