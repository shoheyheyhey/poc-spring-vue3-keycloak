package com.example.backend.transaction;


/**
 * 取引店舗
 */
public class TransactionShop {
    public final ShopId shopId;
    public final String shopName;

    public TransactionShop(String shopId, String shopName) {

        this.shopId = new ShopId(shopId);
        this.shopName = shopName;
    }

}
