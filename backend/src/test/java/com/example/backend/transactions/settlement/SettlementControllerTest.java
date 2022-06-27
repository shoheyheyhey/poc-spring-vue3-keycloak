package com.example.backend.transactions.settlement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest @Transactional
public class SettlementControllerTest {

    @Autowired SettlementController target;

    @Test void 正常系() {
        // given(前提条件)：
        SettlementCreateReq request =
                SettlementCreateReq.builder().settlementAmount(1000).appUserId("1")
                        .paymentMethodId("2").shopId("1").build();

        // when(操作)：
        target.create(request);

        // then(期待する結果):


    }
}
