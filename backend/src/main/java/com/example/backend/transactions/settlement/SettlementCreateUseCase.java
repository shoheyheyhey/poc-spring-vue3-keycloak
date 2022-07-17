package com.example.backend.transactions.settlement;

import com.example.backend.transactions.TransactionAmount;
import com.example.backend.transactions.appuser.AppUserId;
import com.example.backend.transactions.appuser.TransactionAppUser;
import com.example.backend.transactions.appuser.TransactionAppUserRepository;
import com.example.backend.transactions.campaign.GrantCampaignList;
import com.example.backend.transactions.campaign.GrantCampaignListRepository;
import com.example.backend.transactions.paymentmethod.PaymentMethodId;
import com.example.backend.transactions.paymentmethod.WithdrawalService;
import com.example.backend.transactions.paymentmethod.WithdrawalTransactionPaymentMethod;
import com.example.backend.transactions.paymentmethod.WithdrawalTransactionPaymentMethodRepository;
import com.example.backend.transactions.shop.ShopId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component @RequiredArgsConstructor public class SettlementCreateUseCase {

    private final WithdrawalService withdrawalService;
    private final TransactionAppUserRepository transactionAppUserRepository;
    private final GrantCampaignListRepository grantCampaignListRepository;
    private final WithdrawalTransactionPaymentMethodRepository
            withdrawalTransactionPaymentMethodRepository;
    private final SettlementTransactionRepository settlementTransactionRepository;

    @Transactional public SettlementCreateDto execute(SettlementCreateParam param) {

        // ドメインオブジェクト生成
        TransactionAmount transactionAmount = new TransactionAmount(param.getSettlementAmount());
        ShopId shopId = new ShopId(param.getShopId());
        AppUserId appUserId = new AppUserId(param.getAppUserId());
        PaymentMethodId paymentMethodId = new PaymentMethodId(param.getPaymentMethodId());

        WithdrawalTransactionPaymentMethod withdrawalTransactionPaymentMethod =
                withdrawalTransactionPaymentMethodRepository.findById(paymentMethodId);
        TransactionAppUser transactionAppUser = transactionAppUserRepository.findById(appUserId);
        GrantCampaignList grantCampaignList =
                grantCampaignListRepository.findGrantCampaignList(transactionAmount, shopId);
        SettlementTransaction settlementTransaction =
                new SettlementTransaction(transactionAmount, paymentMethodId, shopId, appUserId, grantCampaignList.getTotalPoint());

        // 決済金額上限チェック
        transactionAppUser.checkLimitSettlementAmount(transactionAmount);

        // 出金サービス連携
        withdrawalTransactionPaymentMethod.executeWithdrawalService(withdrawalService);

        // 決済取引情報登録
        settlementTransactionRepository.insert(settlementTransaction);

        return SettlementCreateDto.builder()
                .transactionId(settlementTransaction.transactionId.value).build();

    }

}
