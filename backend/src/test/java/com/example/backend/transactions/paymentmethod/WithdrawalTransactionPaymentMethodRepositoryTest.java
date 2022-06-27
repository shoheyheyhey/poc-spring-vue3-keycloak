package com.example.backend.transactions.paymentmethod;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.shared.TestSupport;
import com.example.jooq.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest @Import({DataSourceConfig.class}) @Transactional
public class WithdrawalTransactionPaymentMethodRepositoryTest extends TestSupport {
    @Autowired private WithdrawalTransactionPaymentMethodRepository
            withdrawalTransactionPaymentMethodRepository;

    @Test public void findByIdで取得できる() {
        // given(前提条件)：

        // when(操作)：
        PaymentMethodId paymentMethodId = new PaymentMethodId("1");
        WithdrawalTransactionPaymentMethod transactionPaymentMethod =
                withdrawalTransactionPaymentMethodRepository.findById(paymentMethodId);

        // then(期待する結果):
        assertEquals("1",
                getPrivateField(getPrivateField(transactionPaymentMethod, "paymentMethodId"),
                        "value"));

    }
}
