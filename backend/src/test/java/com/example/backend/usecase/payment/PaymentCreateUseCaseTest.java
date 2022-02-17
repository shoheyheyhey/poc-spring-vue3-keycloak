package com.example.backend.usecase.payment;

import com.example.jooq.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest @Import({DataSourceConfig.class}) @Transactional
public class PaymentCreateUseCaseTest {
    @Autowired private PaymentCreateUseCase paymentCreateUseCase;

}
