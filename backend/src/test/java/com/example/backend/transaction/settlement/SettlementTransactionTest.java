package com.example.backend.transaction.settlement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SettlementTransactionTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        SettlementTransaction settlementTransaction = TestSettlementTransactionFactory.create();
        assertEquals(100, settlementTransaction.usagePoint.point.value);
    }

}
