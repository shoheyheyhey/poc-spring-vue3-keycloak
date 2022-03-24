package com.example.backend.infra.payment;

import static com.example.jooq.Tables.PAYMENT;
import static com.example.jooq.Tables.PAYMENT_DETAIL;
import static com.example.jooq.Tables.PAYMENT_METHOD_DETAIL;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import com.example.jooq.tables.records.PaymentDetailRecord;
import com.example.jooq.tables.records.PaymentMethodDetailRecord;
import com.example.jooq.tables.records.PaymentRecord;
import java.util.List;
import java.util.stream.Collectors;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional(transactionManager = "transactionManager")
public class PaymentRepositoryImpl implements PaymentRepository {

    @Autowired private DSLContext dsl;

    public void insert(Payment payment) {
        dsl.insertInto(PAYMENT).set(convertDomainToPaymentRecord(payment)).execute();
        dsl.insertInto(PAYMENT_DETAIL, PAYMENT_DETAIL.RECEIPT_ID, PAYMENT_DETAIL.ITEM_NAME,
                        PAYMENT_DETAIL.UNIT_PRICE, PAYMENT_DETAIL.GRANT_POINT)
                .valuesOfRecords(convertDomainToPaymentDetailRecord(payment)).execute();
        dsl.insertInto(PAYMENT_METHOD_DETAIL, PAYMENT_METHOD_DETAIL.RECEIPT_ID,
                        PAYMENT_METHOD_DETAIL.PAYMENT_METHOD_NAME, PAYMENT_METHOD_DETAIL.PAYMENT_AMOUNT,
                        PAYMENT_METHOD_DETAIL.GRANT_POINT)
                .valuesOfRecords(convertDomainToPaymentMethodDetailRecord(payment)).execute();
    }

    public Payment findById(String receiptId) {
        PaymentRecord paymentRecord =
                dsl.selectFrom(PAYMENT).where(PAYMENT.RECEIPT_ID.eq(receiptId)).fetchOne();
        List<PaymentDetailRecord> paymentDetailRecords =
                dsl.selectFrom(PAYMENT_DETAIL).where(PAYMENT_DETAIL.RECEIPT_ID.eq(receiptId))
                        .fetch().stream().collect(Collectors.toList());
        List<PaymentMethodDetailRecord> paymentMethodDetailRecords =
                dsl.selectFrom(PAYMENT_METHOD_DETAIL)
                        .where(PAYMENT_METHOD_DETAIL.RECEIPT_ID.eq(receiptId)).fetch().stream()
                        .collect(Collectors.toList());
        return convertRecordToPayment(paymentRecord, paymentDetailRecords,
                paymentMethodDetailRecords);
    }

    public Payment findByUserId(String userId) {
        PaymentRecord paymentRecord =
                dsl.selectFrom(PAYMENT).where(PAYMENT.USER_ID.eq(userId)).fetchOne();
        List<PaymentDetailRecord> paymentDetailRecords = dsl.selectFrom(PAYMENT_DETAIL)
                .where(PAYMENT_DETAIL.RECEIPT_ID.eq(paymentRecord.getReceiptId())).fetch().stream()
                .collect(Collectors.toList());
        List<PaymentMethodDetailRecord> paymentMethodDetailRecords =
                dsl.selectFrom(PAYMENT_METHOD_DETAIL)
                        .where(PAYMENT_METHOD_DETAIL.RECEIPT_ID.eq(paymentRecord.getReceiptId()))
                        .fetch().stream().collect(Collectors.toList());
        return convertRecordToPayment(paymentRecord, paymentDetailRecords,
                paymentMethodDetailRecords);
    }


    /**
     * 支払エンティティ→PaymentRecord
     *
     * @param payment
     * @return
     */
    private PaymentRecord convertDomainToPaymentRecord(Payment payment) {
        return new PaymentRecord(payment.receiptId, payment.paymentDate.value,
                payment.usagePoint.value, payment.paymentPrice.value, payment.grantTarget,
                payment.userId);
    }

    /**
     * 支払エンティティ→PaymentDetailRecord
     *
     * @param payment
     * @return
     */
    private List<PaymentDetailRecord> convertDomainToPaymentDetailRecord(Payment payment) {
        return payment.paymentDetails.stream().map(paymentDetail -> {
            return new PaymentDetailRecord(payment.receiptId, paymentDetail.itemName,
                    paymentDetail.unitPrice.value, paymentDetail.grantPoint.value);
        }).collect(Collectors.toList());
    }

    /**
     * 支払エンティティ→PaymentMethodDetailRecord
     *
     * @param payment
     * @return
     */
    private List<PaymentMethodDetailRecord> convertDomainToPaymentMethodDetailRecord(
            Payment payment) {
        return payment.paymentMethodDetails.stream().map(paymentMethodDetail -> {
            return new PaymentMethodDetailRecord(payment.receiptId,
                    paymentMethodDetail.paymentMethodName, paymentMethodDetail.paymentAmount.value,
                    paymentMethodDetail.grantPoint.value);
        }).collect(Collectors.toList());
    }

    /**
     * データモデル→支払エンティティ
     *
     * @param paymentRecord
     * @return
     */
    private Payment convertRecordToPayment(PaymentRecord paymentRecord,
            List<PaymentDetailRecord> paymentDetailRecords,
            List<PaymentMethodDetailRecord> paymentMethodDetailRecords) {
        return new Payment(paymentRecord.getReceiptId(),
                new PaymentAndPointDate(paymentRecord.getPaymentDate()),
                new Point(paymentRecord.getUsagePoint()),
                new Price(paymentRecord.getPaymentPrice()), paymentRecord.getGrantType(),
                paymentDetailRecords.stream().map(paymentDetailRecord -> {
                    return new PaymentDetail(paymentDetailRecord.getItemName(),
                            new Price(paymentDetailRecord.getUnitPrice()));
                }).collect(Collectors.toList()),
                paymentMethodDetailRecords.stream().map(paymentMethodDetailRecord -> {
                    return new PaymentMethodDetail(paymentMethodDetailRecord.getPaymentMethodName(),
                            new Price(paymentMethodDetailRecord.getPaymentAmount()));
                }).collect(Collectors.toList()), paymentRecord.getUserId());
    }
}
