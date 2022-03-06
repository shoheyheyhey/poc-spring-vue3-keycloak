package com.example.backend.domain.payment;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.backend.domain.payment.value.Price;
import com.example.backend.domain.shared.exception.DomainException;
import com.example.backend.shared.TestPaymentFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PaymentTest {

    @Test void 支払は支払詳細情報が1つもなければ作成できない() {
        // given(前提条件)：

        // when(操作)：
        List<PaymentDetail> paymentDetails = new ArrayList<>();
        List<PaymentMethodDetail> paymentMethodDetails = new ArrayList<>(
                Arrays.asList(new PaymentMethodDetail("creditCard", new Price(1800))));

        // then(期待する結果):
        assertThrows(DomainException.class, () -> {
            TestPaymentFactory.create(paymentDetails, paymentMethodDetails);
        });

    }

    @Test void 支払は支払方法詳細情報が1つもなければ作成できない() throws DomainException {
        // given(前提条件)：

        // when(操作)：
        List<PaymentDetail> paymentDetails = new ArrayList<>();
        List<PaymentMethodDetail> paymentMethodDetails =
                new ArrayList<>(Arrays.asList(new PaymentMethodDetail("〇〇本", new Price(2000))));



        // then(期待する結果):
        assertThrows(DomainException.class, () -> {
            TestPaymentFactory.create(paymentDetails, paymentMethodDetails);
        });
    }
}
