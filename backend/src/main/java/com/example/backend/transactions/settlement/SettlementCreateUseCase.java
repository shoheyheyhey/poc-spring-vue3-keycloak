package com.example.backend.transactions.settlement;

import com.example.backend.transactions.appuser.AppUserId;
import com.example.backend.transactions.appuser.TransactionAppUser;
import com.example.backend.transactions.appuser.TransactionAppUserRepository;
import com.example.backend.transactions.paymentmethod.PaymentMethodId;
import com.example.backend.transactions.paymentmethod.TransactionPaymentMethod;
import com.example.backend.transactions.paymentmethod.TransactionPaymentMethodRepository;
import com.example.backend.transactions.shop.ShopId;
import com.example.backend.transactions.shop.TransactionShop;
import com.example.backend.transactions.shop.TransactionShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component @RequiredArgsConstructor public class SettlementCreateUseCase {

    private final TransactionPaymentMethodRepository transactionPaymentMethodRepository;
    private final TransactionAppUserRepository transactionAppUserRepository;
    private final TransactionShopRepository transactionShopRepository;

    @Transactional public SettlementCreateDto execute(SettlementCreateParam param) {

        SettlementAmount settlementAmount = new SettlementAmount(param.getSettlementAmount());
        ShopId shopId = new ShopId(param.getShopId());
        AppUserId appUserId = new AppUserId(param.getAppUserId());
        PaymentMethodId paymentMethodId = new PaymentMethodId(param.getPaymentMethodId());

        TransactionPaymentMethod transactionPaymentMethod =
                transactionPaymentMethodRepository.findById(paymentMethodId);
        TransactionAppUser transactionAppUser = transactionAppUserRepository.findById(appUserId);
        TransactionShop transactionShop = transactionShopRepository.findById(shopId);
        SettlementTransaction settlementTransaction =
                new SettlementTransaction(settlementAmount, paymentMethodId, shopId, appUserId);

        // 決済サービス連携

        // 決済取引情報登録

        return SettlementCreateDto.builder()
                .transactionId(settlementTransaction.transactionId.value).build();

    }

}
