package com.example.backend.presentation.user;

import com.example.backend.usecase.user.UserPaymentDto;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder @Data public class UserFindRes {
    /** ユーザ名 */
    private String userName;
    /** ポイント残高 */
    private int remainingPoint;
    /** 支払一覧 */
    private List<UserPaymentDto> userPaymentDtos;

}
