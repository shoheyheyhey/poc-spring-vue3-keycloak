package com.example.backend.transactions.paymentmethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class WithdrawalService {

    @Autowired BankAccountWithdrawalService bankAccountWithdrawalService;

    @Autowired CreditCardWithdrawalService creditCardWithdrawalService;

    @Autowired ElectronicMoneyWithdrawalService electronicMoneyWithdrawalService;

    @Autowired PrepaidCardWithdrawalService prepaidCardWithdrawalService;
}
