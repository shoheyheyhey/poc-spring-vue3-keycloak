package com.example.backend.transactions.shop;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionShopRepository {
    public TransactionShop findById(ShopId shopId);
}
