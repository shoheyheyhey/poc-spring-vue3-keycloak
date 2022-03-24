package com.example.backend.usecase.user;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder @Data public class UserAndPaymentDto {
    /** ユーザ名 */
    private String userName;
    /** ポイント残高 */
    private int remainingPoint;
    /** 支払一覧 */
    private List<UserPaymentDto> userPaymentDtos;

}
