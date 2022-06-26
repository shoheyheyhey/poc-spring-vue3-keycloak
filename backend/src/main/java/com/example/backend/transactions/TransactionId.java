package com.example.backend.transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * 取引ID
 */
public class TransactionId {

    public final String value;

    public TransactionId() {
        Random random = new Random();
        this.value = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now())
                + String.format("%06d", random.nextInt(1000000));

    }

}
