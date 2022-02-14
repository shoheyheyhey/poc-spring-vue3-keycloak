package com.example.backend.infra.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import com.example.jooq.config.DataSourceConfig;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<PaymentDetail> paymentDetails = new ArrayList<>(Arrays.asList(
                PaymentDetail.builder().itemName("〇〇シャンプー").unitPrice(new Price(2000)).build(),
                PaymentDetail.builder().itemName("〇〇本").unitPrice(new Price(3000)).build()));

        List<PaymentMethodDetail> paymentMethodDetails = new ArrayList<>(Arrays.asList(
                PaymentMethodDetail.builder().paymentMethodName("現金").paymentAmount(new Price(2000))
                        .build(), PaymentMethodDetail.builder().paymentMethodName("クレジットカード")
                        .paymentAmount(new Price(2000)).build()));

        Payment payment =
                new Payment("0000000003", new PaymentAndPointDate(LocalDate.of(2021, 1, 1)),
                        new Point(200), new Price(6000), true, paymentDetails, paymentMethodDetails,
                        "0000000001");

        // when(操作)：
        paymentRepository.insert(payment);
        Payment foundPayment = paymentRepository.findById("0000000003");


        // then(期待する結果):
        assertEquals(payment.receiptId, foundPayment.receiptId);
        assertEquals(payment.userId, foundPayment.userId);
        assertEquals(payment.paymentDate.value, foundPayment.paymentDate.value);
        assertEquals(payment.paymentPrice.value, foundPayment.paymentPrice.value);
        assertEquals(payment.receiptId, foundPayment.receiptId);
        // TODO いい感じにオブジェクトの配列を比較できる仕組みを作る
        // assertIterableEquals(payment.paymentDetails, foundPayment.paymentDetails);
        // assertIterableEquals(payment.paymentMethodDetails, foundPayment.paymentMethodDetails);

    }


}
