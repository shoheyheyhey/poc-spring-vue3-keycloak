package com.example.backend.share;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GrantUnitType {
    PERCENT("percent"),
    POINT("point");

    private final String code;
}
