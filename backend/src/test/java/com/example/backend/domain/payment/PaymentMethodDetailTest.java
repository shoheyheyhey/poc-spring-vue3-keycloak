package com.example.backend.domain.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.shared.TestPaymentMethodDetailFactory;
import org.junit.jupiter.api.Test;

class PaymentMethodDetailTest {

    @Test void ポイント付与が正しく行われること() {
        // given(前提条件)：

        // when(操作)：
        PaymentMethodDetail paymentMethodDetail = TestPaymentMethodDetailFactory.create();

        // then(期待する結果):
        assertEquals(40, paymentMethodDetail.grantPoint.value);

    }
}
