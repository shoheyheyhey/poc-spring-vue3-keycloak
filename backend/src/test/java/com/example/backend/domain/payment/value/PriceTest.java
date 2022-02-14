package com.example.backend.domain.payment.value;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.backend.domain.shared.exception.DomainException;
import org.junit.jupiter.api.Test;

public class PriceTest {

    @Test void マイナスポイントは取扱わない() throws DomainException {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        assertThrows(DomainException.class, () -> {
            new Point(-1);
        });

    }
}
