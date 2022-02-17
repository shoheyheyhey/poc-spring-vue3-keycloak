package com.example.backend.presentation.payment;

import com.example.backend.usecase.payment.PaymentCreateUseCase;
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
        paymentCreateUseCase.execute(request);
        return ResponseEntity.ok(new PaymentCreateRes());
    }


}
