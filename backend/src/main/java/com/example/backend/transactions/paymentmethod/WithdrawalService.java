package com.example.backend.transactions.paymentmethod;

import com.example.backend.transactions.paymentmethod.BankAccountWithdrawalService;
import com.example.backend.transactions.paymentmethod.CreditCardWithdrawalService;
import com.example.backend.transactions.paymentmethod.ElectronicMoneyWithdrawalService;
import com.example.backend.transactions.paymentmethod.PrepaidCardWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;

public class WithdrawalService {

    @Autowired BankAccountWithdrawalService bankAccountWithdrawalService;

    @Autowired CreditCardWithdrawalService creditCardWithdrawalService;

    @Autowired ElectronicMoneyWithdrawalService electronicMoneyWithdrawalService;

    @Autowired PrepaidCardWithdrawalService prepaidCardWithdrawalService;
}
