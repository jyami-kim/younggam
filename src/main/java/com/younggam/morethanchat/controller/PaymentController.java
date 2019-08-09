package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.paymentService.PaymentManagementReqDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.PaymentManagementService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.younggam.morethanchat.utils.ResponseMessage.PAYMENT_SUCCESS;

@RestController
@RequestMapping("auth/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final JwtFactory jwtFactory;
    private final PaymentManagementService paymentManagementService;

    @PostMapping("")
    public ResponseDto payTicket(AuthTokenDto authTokenDto, @RequestBody PaymentManagementReqDto paymentManagementReqDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        Long paymentId = paymentManagementService.savePaymentManagement(providerId, paymentManagementReqDto);
        return ResponseDto.of(HttpStatus.OK, PAYMENT_SUCCESS, paymentId);
    }

}
