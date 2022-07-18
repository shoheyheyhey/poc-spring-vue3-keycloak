package com.example.backend.transactions.settlement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.shared.TestSettlementTransactionFactory;
import com.example.backend.shared.TestSupport;
import org.junit.jupiter.api.Test;

class SettlementTransactionTest extends TestSupport {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        SettlementTransaction settlementTransaction = TestSettlementTransactionFactory.create();
        assertEquals("1",
                getPrivateField(getPrivateField(settlementTransaction, "appUserId"), "value"));
    }

}
