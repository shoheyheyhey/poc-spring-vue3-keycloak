package com.example.backend.presentation.payment;

import com.example.backend.presentation.payment.PaymentCreateReq.PaymentDetailReq;
import com.example.backend.presentation.payment.PaymentCreateReq.PaymentMethodDetailReq;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest @Transactional
    public class PaymentControllerTest {

    @Autowired PaymentController target;

    @Test void 複数支払方法で複数商品の支払をポイントも利用して行う() {
        // given(前提条件)：
        PaymentCreateReq request = PaymentCreateReq.builder().receiptId("0000000003")
                .paymentDate(LocalDate.of(2021, 1, 1)).usagePoint(200).paymentPrice(6000)
                .grantTarget(true).paymentDetails(Arrays.asList(
                        PaymentDetailReq.builder().itemName("○○シャンプー").unitPrice(3200).build(),
                        PaymentDetailReq.builder().itemName("○○本").unitPrice(3000).build()))
                .paymentMethodDetails(Arrays.asList(
                        PaymentMethodDetailReq.builder().paymentMethodName("cash").paymentAmount(4000)
                                .build(),
                        PaymentMethodDetailReq.builder().paymentMethodName("creditCard")
                                .paymentAmount(1000).build(),
                        PaymentMethodDetailReq.builder().paymentMethodName("electronicMoney")
                                .paymentAmount(1000).build())).userId("0000000001").build();

        // when(操作)：
        target.create(request);

        // then(期待する結果):


    }
}
