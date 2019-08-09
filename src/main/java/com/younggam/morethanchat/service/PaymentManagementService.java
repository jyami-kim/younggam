package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.PaymentManagement;
import com.younggam.morethanchat.dto.paymentService.PaymentManagementReqDto;
import com.younggam.morethanchat.repository.PaymentManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentManagementService {

    private final PaymentManagementRepository paymentManagementRepository;

    public Long savePaymentManagement(Long providerId, PaymentManagementReqDto paymentManagementReqDto) {
        PaymentManagement paymentManagement = paymentManagementReqDto.toEntity(providerId);
        paymentManagement = paymentManagementRepository.save(paymentManagement);
        return paymentManagement.getId();
    }
}
