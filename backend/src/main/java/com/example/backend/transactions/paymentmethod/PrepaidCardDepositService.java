package com.example.backend.transactions.paymentmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service public class PrepaidCardDepositService {

    Logger logger = LoggerFactory.getLogger(PrepaidCardDepositService.class);


    /**
     * プリペイドカードシステムの入金APIを利用して入金処理を行う
     *
     * @param depositTransactionPaymentMethod
     */
    public void execute(DepositTransactionPaymentMethod depositTransactionPaymentMethod) {
        // 諸々処理
        logger.info("プリペイドカードシステム入金API連携");
    }
}
