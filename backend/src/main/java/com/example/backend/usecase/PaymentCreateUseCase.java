package com.example.backend.usecase;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.domain.payment.value.PaymentAndPointDate;
import com.example.backend.domain.payment.value.Point;
import com.example.backend.domain.payment.value.Price;
import com.example.backend.presentation.payment.PaymentCreateReq;
import com.example.backend.presentation.payment.PaymentCreateReq.PaymentDetailReq;
import com.example.backend.presentation.payment.PaymentCreateReq.PaymentMethodDetailReq;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor public class PaymentCreateUseCase {

    private final PaymentRepository paymentRepository;

    public void execute(PaymentCreateReq paymentCreateReq) {

        paymentRepository.insert(convertRequestToDomain(paymentCreateReq));

    }

    /**
     * リクエストパラメータをドメインにマッピングする
     *
     * @param request
     * @return
     */
    private Payment convertRequestToDomain(PaymentCreateReq request) {
        List<PaymentDetail> paymentDetails = request.getPaymentDetails().stream()
                .map(paymentDetail -> convertRequestToDomain(paymentDetail))
                .collect(Collectors.toList());
        List<PaymentMethodDetail> paymentMethodDetails = request.getPaymentMethodDetails().stream()
                .map(paymentMethodDetail -> convertRequestToDomain(paymentMethodDetail))
                .collect(Collectors.toList());
        return Payment.builder().receiptId(request.getReceiptId())
                .paymentDate(new PaymentAndPointDate(request.getPaymentDate()))
                .grantTarget(request.isGrantTarget()).usagePoint(new Point(request.getUsagePoint()))
                .paymentMethodDetails(paymentMethodDetails).paymentDetails(paymentDetails)
                .paymentPrice(new Price(request.getPaymentPrice())).userId(request.getUserId())
                .build();
    }

    private PaymentDetail convertRequestToDomain(PaymentDetailReq request) {
        return new PaymentDetail(request.getItemName(), new Price(request.getUnitPrice()));

    }

    private PaymentMethodDetail convertRequestToDomain(PaymentMethodDetailReq request) {
        return new PaymentMethodDetail(request.getPaymentMethodName(),
                new Price(request.getPaymentAmount()));

    }

}
