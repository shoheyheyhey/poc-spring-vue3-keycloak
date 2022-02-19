package com.example.backend.shared;

import com.example.backend.domain.payment.User;
import com.example.backend.domain.payment.value.Point;

public class TestUserFactory {
    static private final String userId = "0000000001";
    static private final String userName = "サンプル　太郎";
    static private final Point remainingPoints = new Point(200);

    /**
     * デフォルト設定でユーザ作成
     *
     * @return
     */
    public static User create() {
        return userCreate(userId, userName, remainingPoints);
    }

    /**
     * ユーザID個別設定でユーザ作成
     *
     * @return
     */
    public static User create(String userId) {
        return userCreate(userId, userName, remainingPoints);
    }

    /**
     * ポイント残高個別設定でユーザ作成
     *
     * @return
     */
    public static User create(Point remainingPoints) {
        return userCreate(userId, userName, remainingPoints);
    }


    private static User userCreate(String userId, String userName, Point remainingPoints) {
        return new User(userId, userName, remainingPoints);
    }

}
