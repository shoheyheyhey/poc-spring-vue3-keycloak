package com.example.backend.domain.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.shared.TestPaymentDetailFactory;
import org.junit.jupiter.api.Test;

class PaymentDetailTest {

    @Test void ポイント付与が正しく行われること() {
        // given(前提条件)：

        // when(操作)：
        PaymentDetail paymentDetail = TestPaymentDetailFactory.create();

        // then(期待する結果):
        assertEquals(20, paymentDetail.grantPoint.value);

    }
}
