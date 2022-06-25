package com.example.backend.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdjustCampaignsTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        PointPaymentMethod pointPaymentMethod = TestPointPaymentMethodFactory.create();
        assertEquals("1", pointPaymentMethod.paymentMethodId.value);
    }


}
