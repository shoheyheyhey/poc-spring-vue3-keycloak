package com.example.backend.presentation.user;

import com.example.backend.usecase.user.UserAndPaymentDto;
import com.example.backend.usecase.user.UserAndPaymentDtoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController @Validated public class UserController {

    @Autowired private UserAndPaymentDtoQueryService userAndPaymentDtoQueryService;


    @GetMapping("/user/{userId}")
    public ResponseEntity<UserFindRes> find(@PathVariable("userId") String userId) {

        UserAndPaymentDto userAndPaymentDto = userAndPaymentDtoQueryService.fetchList(userId);
        return ResponseEntity.ok(UserFindRes.builder().userName(userAndPaymentDto.getUserName())
                .remainingPoint(userAndPaymentDto.getRemainingPoint())
                .userPaymentDtos(userAndPaymentDto.getUserPaymentDtos()).build());
    }

}
