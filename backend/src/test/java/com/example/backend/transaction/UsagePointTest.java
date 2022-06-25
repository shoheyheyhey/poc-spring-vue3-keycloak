package com.example.backend.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.backend.domain.shared.exception.DomainException;
import org.junit.jupiter.api.Test;

class UsagePointTest {

    @Test void 正常にインスタンス化できる() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        UsagePoint usagePoint = TestUsagePointFactory.create();
        assertEquals(100, usagePoint.point.value);
    }

    @Test void 利用ポイントが０未満でエラー() {
        // given(前提条件)：

        // when(操作)：

        // then(期待する結果):
        assertThrows(DomainException.class, () -> {
            TestUsagePointFactory.create(new Point(-100));
        });
    }


}
