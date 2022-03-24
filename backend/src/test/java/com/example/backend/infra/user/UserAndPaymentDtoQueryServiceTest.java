package com.example.backend.infra.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.shared.TestPaymentFactory;
import com.example.backend.usecase.user.UserAndPaymentDto;
import com.example.backend.usecase.user.UserAndPaymentDtoQueryService;
import com.example.jooq.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest @Import({DataSourceConfig.class}) @Transactional
public class UserAndPaymentDtoQueryServiceTest {
    @Autowired private UserAndPaymentDtoQueryService userAndPaymentDtoQueryService;

    @Test public void ユーザIDで取得できる() {
        // given(前提条件)：

        // when(操作)：
        String userId = "0000000001";
        UserAndPaymentDto userAndPaymentDto = userAndPaymentDtoQueryService.fetchList(userId);


        // then(期待する結果):
        assertEquals("サンプル 太郎", userAndPaymentDto.getUserName());
        assertEquals(500, userAndPaymentDto.getRemainingPoint());
        assertEquals(200, userAndPaymentDto.getUserPaymentDtos().get(0).getUsagePoint());

    }


}
