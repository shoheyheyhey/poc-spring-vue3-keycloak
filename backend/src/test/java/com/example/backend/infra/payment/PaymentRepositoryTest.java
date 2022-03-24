package com.example.backend.infra.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.shared.TestPaymentFactory;
import com.example.jooq.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest @Import({DataSourceConfig.class}) @Transactional
public class PaymentRepositoryTest {
    @Autowired private PaymentRepository paymentRepository;

    @Test public void insertしたものがfindByIdで取得できる() {
        // given(前提条件)：

        // when(操作)：
        String receiptId = "0000000003";
        Payment payment = TestPaymentFactory.create(receiptId);
        paymentRepository.insert(payment);
        Payment foundPayment = paymentRepository.findById(receiptId);


        // then(期待する結果):
        assertEquals(payment.receiptId, foundPayment.receiptId);
        assertEquals(payment.userId, foundPayment.userId);
        assertEquals(payment.paymentDate.value, foundPayment.paymentDate.value);
        assertEquals(payment.paymentPrice.value, foundPayment.paymentPrice.value);
        assertEquals(payment.userId, foundPayment.userId);
        assertEquals(payment.paymentDetails.get(0).itemName,
                foundPayment.paymentDetails.get(0).itemName);
        assertEquals(payment.paymentDetails.get(0).unitPrice.value,
                foundPayment.paymentDetails.get(0).unitPrice.value);
        assertEquals(payment.paymentDetails.get(0).grantPoint.value,
                foundPayment.paymentDetails.get(0).grantPoint.value);

        assertEquals(payment.paymentMethodDetails.get(0).paymentAmount.value,
                foundPayment.paymentMethodDetails.get(0).paymentAmount.value);
        assertEquals(payment.paymentMethodDetails.get(0).paymentMethodName,
                foundPayment.paymentMethodDetails.get(0).paymentMethodName);
        assertEquals(payment.paymentMethodDetails.get(0).grantPoint.value,
                foundPayment.paymentMethodDetails.get(0).grantPoint.value);

    }


}
