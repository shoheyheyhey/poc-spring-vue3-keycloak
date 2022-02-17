package com.example.backend.domain.payment.domainservice;

import com.example.backend.domain.payment.Payment;
import com.example.backend.domain.payment.User;
import com.example.backend.domain.shared.exception.DomainException;
import org.springframework.stereotype.Service;

@Service
public class ExcessPointUsageCheck {
    static public void execute(Payment payment, User user) {
        if(user.remainingPoint.value < payment.usagePoint.value) {
            throw new DomainException("利用ポイント数がユーザの残ポイントを超過しています");
        }
    }
}
