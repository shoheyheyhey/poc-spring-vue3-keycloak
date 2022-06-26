package com.example.backend.transactions.settlement;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor @Validated public class SettlementController {

    private final SettlementCreateUseCase paymentCreateUseCase;


    @PostMapping("/settlement") public ResponseEntity<SettlementCreateRes> create(
            @RequestBody @Valid SettlementCreateReq request) {

        SettlementCreateParam param = convertRequestToParam(request);

        SettlementCreateDto dto = paymentCreateUseCase.execute(param);
        return ResponseEntity.ok(SettlementCreateRes.builder().transactionId(dto.getTransactionId()).build());
    }

    /**
     * リクエストパラメータからユースケース受け渡し用Param作成
     *
     * @param request APIリクエストパラメータ
     * @return ユースケースParam
     */
    private SettlementCreateParam convertRequestToParam(SettlementCreateReq request) {

        return SettlementCreateParam.builder().settlementAmount(request.getSettlementAmount())
                .appUserId(request.getAppUserId()).paymentMethodId(request.getPaymentMethodId())
                .shopId(request.getShopId()).build();
    }

}
