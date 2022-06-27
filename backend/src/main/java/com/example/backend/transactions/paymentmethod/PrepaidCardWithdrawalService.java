package com.example.backend.transactions.paymentmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service public class PrepaidCardWithdrawalService {

    Logger logger = LoggerFactory.getLogger(PrepaidCardWithdrawalService.class);

    /**
     * プリペイドカードシステムの出金APIを利用して出金処理を行う
     *
     * @param withdrawalTransactionPaymentMethod
     */
    public void execute(WithdrawalTransactionPaymentMethod withdrawalTransactionPaymentMethod) {
        // 諸々処理
        logger.info("プリペイドカードシステム出金API連携");
    }
}
