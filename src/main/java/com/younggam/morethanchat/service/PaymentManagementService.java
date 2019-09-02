package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.PaymentManagement;
import com.younggam.morethanchat.dto.paymentService.ImPortInfoDto;
import com.younggam.morethanchat.dto.paymentService.ImportDefaultResDto;
import com.younggam.morethanchat.dto.paymentService.PaymentManagementReqDto;
import com.younggam.morethanchat.dto.paymentService.PaymentSubmitReqDto;
import com.younggam.morethanchat.repository.PaymentManagementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentManagementService {

    private final PaymentManagementRepository paymentManagementRepository;
    private final ImPortInfoDto imPortInfoDto;
    private final RestTemplate restTemplate;

    @Value("${import.url.getToken}")
    private String importTokenURL;

    @Value("${import.url.getPayments}")
    private String importPaymentsURL;

    public String savePaymentManagement(Long providerId, PaymentManagementReqDto paymentManagementReqDto) {
        PaymentManagement paymentManagement = paymentManagementReqDto.toEntity(providerId);
        paymentManagement = paymentManagementRepository.save(paymentManagement);
        return paymentManagement.getId();
    }


    public void savePaymentSuccess(PaymentSubmitReqDto submitReqDto) {
        String accessToken = getAccessToken();
        log.info(accessToken);
        getPaymentDataFromImport(submitReqDto, accessToken);
    }

    private String getAccessToken() {
        ImportDefaultResDto importTokenDto = restTemplate.postForObject(importTokenURL, imPortInfoDto, ImportDefaultResDto.class);
        ResponseEntity<String> entity = restTemplate.postForEntity(importTokenURL, imPortInfoDto, String.class);
        log.info(entity.toString());
        return importTokenDto.getResponse().getAccessToken();
    }

    private void getPaymentDataFromImport(PaymentSubmitReqDto submitReqDto, String accessToken) {

        String impUid = submitReqDto.getImpUid();
        log.info(impUid);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, accessToken);
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpEntity<String> request = new HttpEntity<>(headers);
//        ResponseEntity<String> forEntity = restTemplate.getForObject(importPaymentsURL + "/" + accessToken, String.class);

        ResponseEntity<Map> response = restTemplate.exchange(
                importPaymentsURL + impUid, HttpMethod.GET, request, Map.class);

        System.out.println(response.getBody());

        log.info(response.toString());
    }

}
