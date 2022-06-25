package com.example.backend.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.backend.domain.shared.exception.DomainException;
import org.junit.jupiter.api.Test;

class PointPaymentMethodTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        PointPaymentMethod pointPaymentMethod = TestPointPaymentMethodFactory.create();
        assertEquals("1", pointPaymentMethod.paymentMethodId.value);
    }

    @Test void 決済手段がプリペイドカード以外でエラー() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        assertThrows(DomainException.class, () -> {
            TestPointPaymentMethodFactory.create("credit_card");
        });
    }


}
