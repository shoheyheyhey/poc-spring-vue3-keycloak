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
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component @RequiredArgsConstructor public class PaymentCreateUseCase {

    private final PaymentRepository paymentRepository;
    private final PointHistoryRepository pointHistoryRepository;
    private final UserRepository userRepository;

    @Transactional public String execute(PaymentCreateParam param) {

        // 渡された値を基にエンティティ作成
        Payment payment = convertRequestToPayment(param);
        PointHistory pointHistory = convertRequestToPointHistory(param);

        // 利用ポイントがユーザのポイント残高超過チェック
        User user = userRepository.findById(param.getUserId());
        ExcessPointUsageCheck.execute(payment, user);

        // 支払情報登録
        paymentRepository.insert(payment);
        pointHistoryRepository.insert(pointHistory);

        return payment.receiptId;

    }

    /**
     * 渡された値から支払エンティティを作成
     *
     * @param param
     * @return
     */
    private Payment convertRequestToPayment(PaymentCreateParam param) {
        List<PaymentDetail> paymentDetails = param.getPaymentDetails().stream()
                .map(paymentDetail -> new PaymentDetail(paymentDetail.getItemName(),
                        new Price(paymentDetail.getUnitPrice()))).collect(Collectors.toList());

        List<PaymentMethodDetail> paymentMethodDetails = param.getPaymentMethodDetails().stream()
                .map(paymentMethodDetail -> new PaymentMethodDetail(
                        paymentMethodDetail.getPaymentMethodName(),
                        new Price(paymentMethodDetail.getPaymentAmount())))
                .collect(Collectors.toList());

        return new Payment(param.getReceiptId(), new PaymentAndPointDate(param.getPaymentDate()),
                new Point(param.getUsagePoint()), new Price(param.getPaymentPrice()),
                param.isGrantTarget(), paymentDetails, paymentMethodDetails, param.getUserId());
    }

    /**
     * 渡された値ポイント履歴エンティティを作成
     *
     * @param param
     * @return
     */
    private PointHistory convertRequestToPointHistory(PaymentCreateParam param) {
        return new PointHistory(param.getUserId(), param.getReceiptId(),
                new Point(param.getUsagePoint()), new PaymentAndPointDate(param.getPaymentDate()));
    }

}
