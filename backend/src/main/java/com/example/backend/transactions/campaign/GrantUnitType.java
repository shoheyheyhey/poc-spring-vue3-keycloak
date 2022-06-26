package com.example.backend.transactions.campaign;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GrantUnitType {
    RATE("rate"),
    POINT("point");

    private final String code;
}
