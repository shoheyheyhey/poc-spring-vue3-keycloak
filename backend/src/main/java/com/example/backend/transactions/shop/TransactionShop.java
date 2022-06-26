package com.example.backend.transactions.shop;


/**
 * 取引店舗
 */
public class TransactionShop {
    final ShopId shopId;
    final String shopName;

    public TransactionShop(String shopId, String shopName) {

        this.shopId = new ShopId(shopId);
        this.shopName = shopName;
    }

}
