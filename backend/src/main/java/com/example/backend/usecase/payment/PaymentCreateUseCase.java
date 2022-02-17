package com.example.backend.usecase.payment;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentDetail;
import com.example.backend.domain.payment.PaymentMethodDetail;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.domain.payment.PointHistory;
import com.example.backend.domain.payment.PointHistoryRepository;
import com.example.backend.domain.payment.User;
import com.example.backend.domain.payment.UserRepository;
import com.example.backend.domain.payment.domainservice.ExcessPointUsageCheck;
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
import org.springframework.transaction.annotation.Transactional;

@Component @RequiredArgsConstructor public class PaymentCreateUseCase {

    private final PaymentRepository paymentRepository;
    private final PointHistoryRepository pointHistoryRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(PaymentCreateReq paymentCreateReq) {
        // リクエストパラメータからドメインオブジェクト作成
        Payment payment = convertRequestToPayment(paymentCreateReq);
        PointHistory pointHistory = convertRequestToPointHistory(paymentCreateReq);


        // 利用ポイントがユーザのポイント残高超過チェック
        User user = userRepository.findById(payment.userId);
        ExcessPointUsageCheck.execute(payment, user);

        // 支払情報登録
        paymentRepository.insert(payment);
        pointHistoryRepository.insert(pointHistory);

    }

    /**
     * リクエストパラメータから支払エンティティを作成
     *
     * @param request
     * @return
     */
    private Payment convertRequestToPayment(PaymentCreateReq request) {
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

    /**
     * リクエストパラメータからポイント履歴エンティティを作成
     *
     * @param request
     * @return
     */
    private PointHistory convertRequestToPointHistory(PaymentCreateReq request) {
        return PointHistory.builder().receiptId(request.getReceiptId()).userId(request.getUserId())
                .pointUsageDate(new PaymentAndPointDate(request.getPaymentDate()))
                .usagePoint(new Point(request.getUsagePoint())).build();
    }

}
