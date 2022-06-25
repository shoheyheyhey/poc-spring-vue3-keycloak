package com.example.backend.transaction.settlement;

import com.example.backend.domain.shared.exception.DomainException;

/** 決済金額 */
public class SettlementAmount {
    public final int value;

    public SettlementAmount(int value) {
        if(value < 0 || value > 100000000) {
            throw new DomainException("決済金額が不正です。");
        }

        this.value = value;

    }

}
