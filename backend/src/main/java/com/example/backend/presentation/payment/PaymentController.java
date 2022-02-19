package com.example.backend.presentation.payment;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.PointHistory;
import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import com.example.backend.usecase.payment.PaymentCreateUseCase;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @Validated public class PaymentController {

    @Autowired private PaymentCreateUseCase paymentCreateUseCase;


    @PostMapping("/payment")
    public ResponseEntity<PaymentCreateRes> create(@RequestBody @Valid PaymentCreateReq request) {
        // リクエストパラメータからドメインオブジェクト作成
        Payment payment = convertRequestToPayment(request);
        PointHistory pointHistory = convertRequestToPointHistory(request);

        String receiptId = paymentCreateUseCase.execute(payment, pointHistory);
        return ResponseEntity.ok(PaymentCreateRes.builder().receiptId(receiptId).build());
    }

    /**
     * リクエストパラメータから支払エンティティを作成
     *
     * @param request
     * @return
     */
    private Payment convertRequestToPayment(PaymentCreateReq request) {
        List<PaymentDetail> paymentDetails = request.getPaymentDetails().stream()
                .map(paymentDetail -> new PaymentDetail(paymentDetail.getItemName(),
                        new Price(paymentDetail.getUnitPrice()))).collect(Collectors.toList());

        List<PaymentMethodDetail> paymentMethodDetails = request.getPaymentMethodDetails().stream()
                .map(paymentMethodDetail -> new PaymentMethodDetail(
                        paymentMethodDetail.getPaymentMethodName(),
                        new Price(paymentMethodDetail.getPaymentAmount())))
                .collect(Collectors.toList());

        return new Payment(request.getReceiptId(),
                new PaymentAndPointDate(request.getPaymentDate()),
                new Point(request.getUsagePoint()), new Price(request.getPaymentPrice()),
                request.isGrantTarget(), paymentDetails, paymentMethodDetails, request.getUserId());
    }

    /**
     * リクエストパラメータからポイント履歴エンティティを作成
     *
     * @param request
     * @return
     */
    private PointHistory convertRequestToPointHistory(PaymentCreateReq request) {
        return new PointHistory(request.getUserId(), request.getReceiptId()
                ,new Point(request.getUsagePoint())
                ,new PaymentAndPointDate(request.getPaymentDate()));
    }
}
