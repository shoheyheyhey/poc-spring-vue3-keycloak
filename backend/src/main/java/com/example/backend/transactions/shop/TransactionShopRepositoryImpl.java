package com.example.backend.transactions.shop;

import static com.example.jooq.Tables.SHOP;

import com.example.backend.shared.exception.InfraException;
import com.example.jooq.tables.records.ShopRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository @Transactional(transactionManager = "transactionManager")
public class TransactionShopRepositoryImpl implements TransactionShopRepository {

    @Autowired private DSLContext dsl;

    public TransactionShop findById(ShopId shopId) {
        ShopRecord shopRecord =
                dsl.selectFrom(SHOP).where(SHOP.SHOP_ID.eq(shopId.value)).fetchOne();
        if (shopRecord == null) {
            throw new InfraException("店舗が存在しません");
        }
        return convertDomainObject(shopRecord);
    }


    /**
     * 取引店舗オブジェクトを生成する
     *
     * @param record 店舗レコード情報
     * @return 取引店舗ドメインオブジェクト
     */
    private TransactionShop convertDomainObject(ShopRecord record) {
        return new TransactionShop(record.getShopId(), record.getShopName());
    }
}
