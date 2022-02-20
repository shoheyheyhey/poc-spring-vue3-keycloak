package com.example.backend.presentation.payment;

import com.example.backend.usecase.payment.PaymentCreateDto;
import com.example.backend.usecase.payment.PaymentCreateParam;
import com.example.backend.usecase.payment.PaymentCreateParam.PaymentDetailParam;
import com.example.backend.usecase.payment.PaymentCreateParam.PaymentMethodDetailParam;
import com.example.backend.usecase.payment.PaymentCreateUseCase;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @Validated public class PaymentController {

    @Autowired private PaymentCreateUseCase paymentCreateUseCase;


    @PostMapping("/payment")
    public ResponseEntity<PaymentCreateRes> create(@RequestBody @Valid PaymentCreateReq request) {

        PaymentCreateParam param = convertRequestToParam(request);


        PaymentCreateDto dto = paymentCreateUseCase.execute(param);
        return ResponseEntity.ok(PaymentCreateRes.builder().receiptId(dto.getReceiptId()).build());
    }

    /**
     * リクエストパラメータからユースケース受け渡し用Param作成
     *
     * @param request
     * @return
     */
    private PaymentCreateParam convertRequestToParam(PaymentCreateReq request) {
        List<PaymentDetailParam> paymentDetails = request.getPaymentDetails().stream()
                .map(paymentDetail -> PaymentDetailParam.builder()
                        .itemName(paymentDetail.getItemName())
                        .unitPrice(paymentDetail.getUnitPrice()).build())
                .collect(Collectors.toList());

        List<PaymentMethodDetailParam> paymentMethodDetails =
                request.getPaymentMethodDetails().stream()
                        .map(paymentMethodDetail -> PaymentMethodDetailParam.builder()
                                .paymentMethodName(paymentMethodDetail.getPaymentMethodName())
                                .paymentAmount(paymentMethodDetail.getPaymentAmount()).build())
                        .collect(Collectors.toList());

        return PaymentCreateParam.builder().receiptId(request.getReceiptId())
                .paymentDate(request.getPaymentDate()).usagePoint(request.getUsagePoint())
                .paymentPrice(request.getPaymentPrice()).grantTarget(request.isGrantTarget())
                .paymentDetails(paymentDetails).paymentMethodDetails(paymentMethodDetails)
                .userId(request.getUserId()).build();
    }

}
