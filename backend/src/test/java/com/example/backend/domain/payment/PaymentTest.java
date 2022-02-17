package com.example.backend.domain.payment;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import com.example.backend.domain.shared.exception.DomainException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PaymentTest {

    @Test void 支払は支払詳細情報が1つもなければ作成できない() {
        // given(前提条件)：

        // when(操作)：
        String receiptId = "0000000001";
        PaymentAndPointDate paymentDate = new PaymentAndPointDate(LocalDate.of(2021, 1, 1));
        Point usagePoint = new Point(200);
        Price paymentPrice = new Price(2000);
        Boolean grantTarget = true;
        List<PaymentDetail> paymentDetails = new ArrayList<>();
        List<PaymentMethodDetail> paymentMethodDetails = new ArrayList<>();
        PaymentMethodDetail paymentMethodDetail =
                new PaymentMethodDetail("クレジットカード", new Price(2000));
        paymentMethodDetails.add(paymentMethodDetail);
        String userId = "0000000001";

        // then(期待する結果):
        assertThrows(DomainException.class, () -> {
            new Payment(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                    paymentDetails, paymentMethodDetails, userId);
        });

    }

    @Test void 支払は支払方法詳細情報が1つもなければ作成できない() throws DomainException {
        // given(前提条件)：

        // when(操作)：
        String receiptId = "0000000001";
        PaymentAndPointDate paymentDate = new PaymentAndPointDate(LocalDate.of(2021, 1, 1));
        Point usagePoint = new Point(200);
        Price paymentPrice = new Price(2000);
        Boolean grantTarget = true;
        List<PaymentDetail> paymentDetails = new ArrayList<>();
        List<PaymentMethodDetail> paymentMethodDetails = new ArrayList<>();
        PaymentDetail paymentDetail = new PaymentDetail("〇〇本", new Price(2000));
        paymentDetails.add(paymentDetail);
        String userId = "0000000001";

        // then(期待する結果):
        assertThrows(DomainException.class, () -> {
            new Payment(receiptId, paymentDate, usagePoint, paymentPrice, grantTarget,
                    paymentDetails, paymentMethodDetails, userId);
        });
    }
}
