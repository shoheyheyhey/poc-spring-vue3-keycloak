package com.example.backend.transactions.paymentmethod;

import com.example.backend.transactions.paymentmethod.TransactionPaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BankAccountWithdrawalService {

    Logger logger = LoggerFactory.getLogger(CreditCardWithdrawalService.class);

    /**
     * 銀行口座システムの出金APIを利用して出金処理を行う
     * @param withdrawalTransactionPaymentMethod
     */
    public void execute(WithdrawalTransactionPaymentMethod withdrawalTransactionPaymentMethod){
        // 諸々処理
        logger.info("銀行口座システム出金API連携");
    }
}
