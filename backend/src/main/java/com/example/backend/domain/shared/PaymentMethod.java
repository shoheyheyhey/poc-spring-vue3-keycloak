package com.example.backend.domain.shared;

import com.example.backend.domain.payment.value.PointRate;

public interface PaymentMethod {
    PointRate pointRate();
}
