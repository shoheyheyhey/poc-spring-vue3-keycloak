package com.example.backend.transaction.settlement;

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
import com.example.backend.usecase.payment.PaymentCreateDto;
import com.example.backend.usecase.payment.PaymentCreateParam;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component @RequiredArgsConstructor public class SettlementCreateUseCase {

    private final PaymentRepository paymentRepository;
    private final PointHistoryRepository pointHistoryRepository;
    private final UserRepository userRepository;

    @Transactional public PaymentCreateDto execute(PaymentCreateParam param) {

        // 渡された値を基にエンティティ作成
        Payment payment = convertParamToPayment(param);

        // 支払い時のポイント利用がある場合はユーザのポイント残高超過チェックしてポイント履歴登録
        if(payment.isUsagePoint()){
            User user = userRepository.findById(param.getUserId());
            ExcessPointUsageCheck.execute(payment, user);
            PointHistory pointHistory = convertParamToPointHistory(param);
            pointHistoryRepository.insert(pointHistory);
        }

        // 支払情報登録
        paymentRepository.insert(payment);

        return convertDto(payment.receiptId);

    }

    /**
     * 渡されたParamから支払エンティティを作成
     *
     * @param param
     * @return
     */
    private Payment convertParamToPayment(PaymentCreateParam param) {
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
     * 渡されたParamから値ポイント履歴エンティティを作成
     *
     * @param param
     * @return
     */
    private PointHistory convertParamToPointHistory(PaymentCreateParam param) {
        return new PointHistory(param.getUserId(), param.getReceiptId(),
                new Point(param.getUsagePoint()), new PaymentAndPointDate(param.getPaymentDate()));
    }

    private PaymentCreateDto convertDto(String receiptId) {
        return PaymentCreateDto.builder().receiptId(receiptId).build();
    }

}
