package com.example.backend.transactions.campaign;

import com.example.backend.shared.exception.DomainException;

/** ポイント */
public class Point {
    public final int value;

    public Point(int value) {
        if(value < 0 || value > 1000000) {
            throw new DomainException("ポイント数が不正です。");
        }

        this.value = value;

    }

}
