package com.example.backend.shared;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPaymentDetailFactory {

    static private final String itemName = "〇〇シャンプー";
    static private final Price unitPrice = new Price(2000);

    /**
     * デフォルト設定で支払明細作成
     *
     * @return
     */
    public static PaymentDetail create() {
        return new PaymentDetail(itemName,unitPrice);
    }


}
