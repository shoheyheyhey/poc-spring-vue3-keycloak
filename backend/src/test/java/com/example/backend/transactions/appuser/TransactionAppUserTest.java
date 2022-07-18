package com.example.backend.transactions.appuser;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.backend.shared.TestTransactionAppUserFactory;
import com.example.backend.shared.exception.DomainException;
import com.example.backend.transactions.TransactionAmount;
import org.junit.jupiter.api.Test;

class TransactionAppUserTest {

    @Test void 正常にインスタンス化できて決済上限チェックがOKになること() {
        // given(前提条件)：
        TransactionAppUser transactionAppUser =
                TestTransactionAppUserFactory.create();

        // when(操作)：

        // then(期待する結果):
        assertDoesNotThrow(() -> transactionAppUser.checkLimitSettlementAmount(new TransactionAmount(10000)));

    }

    @Test void 決済上限チェックがNGになること() {
        // given(前提条件)：
        TransactionAppUser transactionAppUser =
                TestTransactionAppUserFactory.create();

        // when(操作)：

        // then(期待する結果):
        assertThrows(DomainException.class, () -> transactionAppUser.checkLimitSettlementAmount(new TransactionAmount(10001)));

    }

}
