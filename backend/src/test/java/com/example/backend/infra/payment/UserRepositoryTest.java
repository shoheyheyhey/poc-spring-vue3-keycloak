package com.example.backend.infra.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backend.domain.payment.User;
import com.example.backend.domain.payment.UserRepository;
import com.example.jooq.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest @Import({DataSourceConfig.class}) @Transactional public class UserRepositoryTest {
    @Autowired private UserRepository userRepository;

    @Test public void 指定したユーザIDをfindByIdで取得できる() {
        // given(前提条件)：
        String userId = "0000000001";

        // when(操作)：
        User user = userRepository.findById("0000000001");


        // then(期待する結果):
        assertEquals("0000000001", user.userId);
        assertEquals("サンプル 太郎", user.userName);
        assertEquals(500, user.remainingPoint.value);
    }


}
