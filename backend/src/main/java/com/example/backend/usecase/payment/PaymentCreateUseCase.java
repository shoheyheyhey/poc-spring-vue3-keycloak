package com.example.backend.usecase.payment;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.PaymentRepository;
import com.example.backend.domain.payment.PointHistory;
import com.example.backend.domain.payment.PointHistoryRepository;
import com.example.backend.domain.payment.User;
import com.example.backend.domain.payment.UserRepository;
import com.example.backend.domain.payment.domainservice.ExcessPointUsageCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component @RequiredArgsConstructor public class PaymentCreateUseCase {

    private final PaymentRepository paymentRepository;
    private final PointHistoryRepository pointHistoryRepository;
    private final UserRepository userRepository;

    @Transactional public String execute(Payment payment, PointHistory pointHistory) {

        // 利用ポイントがユーザのポイント残高超過チェック
        User user = userRepository.findById(payment.userId);
        ExcessPointUsageCheck.execute(payment, user);

        // 支払情報登録
        paymentRepository.insert(payment);
        pointHistoryRepository.insert(pointHistory);

        return payment.receiptId;

    }

}
