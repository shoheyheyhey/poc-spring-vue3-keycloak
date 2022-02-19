package com.example.backend.domain.payment.domainservice;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.User;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.shared.exception.DomainException;
import com.example.backend.shared.TestPaymentFactory;
import org.junit.jupiter.api.Test;

public class ExcessPointUsageCheckTest {

    @Test void ユーザのポイント残高が支払いの利用ポイント以上の場合は何も起きない() {
        // given(前提条件)：
        Payment payment = TestPaymentFactory.create(new Point(500));
        User user = new User("0000000001", "田中 太郎", new Point(500));

        // when(操作)：
        ExcessPointUsageCheck.execute(payment, user);

        // then(期待する結果):
        // 何も起きない

    }

    @Test void ユーザのポイント残高が支払いの利用ポイントより小さい場合はDomainException() {
        // given(前提条件)：
        Payment payment = TestPaymentFactory.create(new Point(500));
        User user = new User("0000000001", "田中 太郎", new Point(499));

        // when(操作)：
        assertThrows(DomainException.class, () -> {
            ExcessPointUsageCheck.execute(payment, user);
        });
    }
}
