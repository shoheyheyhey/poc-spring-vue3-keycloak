package com.example.backend.transactions.paymentmethod;

import static com.example.jooq.Tables.PAYMENT_METHOD;

import com.example.backend.shared.exception.InfraException;
import com.example.jooq.tables.records.PaymentMethodRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional(transactionManager = "transactionManager")
public class WithdrawalTransactionPaymentMethodRepositoryImpl
        implements WithdrawalTransactionPaymentMethodRepository {

    @Autowired private DSLContext dsl;

    public WithdrawalTransactionPaymentMethod findById(PaymentMethodId paymentMethodId) {
        PaymentMethodRecord paymentMethodRecord = dsl.selectFrom(PAYMENT_METHOD)
                .where(PAYMENT_METHOD.PAYMENT_METHOD_ID.eq(paymentMethodId.value)).fetchOne();
        if (paymentMethodRecord == null) {
            throw new InfraException("決済手段が存在しません");
        }
        return WithdrawalTransactionPaymentMethod.factoryPaymentMethod(paymentMethodRecord.getPaymentMethodId(),
                paymentMethodRecord.getPaymentType());
    }

}
