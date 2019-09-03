package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.PaymentManagement;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.paymentService.*;
import com.younggam.morethanchat.dto.paymentService.ImportDefaultRes.ImportPaymentDefaultReqDto;
import com.younggam.morethanchat.dto.paymentService.ImportDefaultRes.ImportTokenDefaultResDto;
import com.younggam.morethanchat.exception.NotAccessException;
import com.younggam.morethanchat.repository.PaymentManagementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.younggam.morethanchat.utils.ResponseMessage.*;
import static com.younggam.morethanchat.utils.TypeConverter.getCalculateDate;
import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

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

    public ResponseDto savePaymentSuccess(PaymentSubmitReqDto submitReqDto) {
        String accessToken = getAccessToken();

        ImportPaymentReqDto paymentDataFromImport = getPaymentDataFromImport(submitReqDto, accessToken);
        PaymentManagement paymentManagement = paymentManagementRepository.findById(submitReqDto.getMerchantUid())
                .orElseThrow(() -> new NotAccessException(NOT_SAVING_MORETHAN_PAYMENT));

        int moreThanServerAmount = paymentManagement.getTotalAmount();
        int importPaymentAmount = paymentDataFromImport.getAmount();

        if (moreThanServerAmount == importPaymentAmount) {

            paymentManagement.setPayDate(getNowAllDate());
            paymentManagement.setDueDate(getCalculatedDueDate(paymentManagement.getServicePeriod()));
            paymentManagementRepository.save(paymentManagement);

            return afterPayment(paymentDataFromImport);

        } else {
            throw new NotAccessException(PAYMENT_FORGERY_MODULATION);
        }

    }

    private ResponseDto afterPayment(ImportPaymentReqDto paymentDataFromImport) {
        switch (paymentDataFromImport.getStatus()) {
            case "ready": // 가상계좌발급
//                vbank_num, vbank_date, vbank_name
                return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "현재 가상계좌 결제가 불가능합니다");

            case "paid": // 결제완료
                return ResponseDto.of(HttpStatus.OK, PAYMENT_SUCCESS);
        }
        return ResponseDto.FAIL_DEFAULT_RES;
    }


    private String getCalculatedDueDate(int servicePeriod) {
        int month = PaymentGroupServicePeriod.findBySelectNum(servicePeriod).getMonth();
        return getCalculateDate(month);
    }

    private String getAccessToken() {
        ImportTokenDefaultResDto importTokenDto =
                restTemplate.postForObject(importTokenURL, imPortInfoDto, ImportTokenDefaultResDto.class);
        ResponseEntity<String> entity = restTemplate.postForEntity(importTokenURL, imPortInfoDto, String.class);
        log.info(entity.toString());
        return importTokenDto.getResponse().getAccessToken();
    }

    private ImportPaymentReqDto getPaymentDataFromImport(PaymentSubmitReqDto submitReqDto, String accessToken) {

        String impUid = submitReqDto.getImpUid();
        log.info(impUid);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, accessToken);
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<ImportPaymentDefaultReqDto> payment = restTemplate.exchange(
                importPaymentsURL + impUid, HttpMethod.GET, request, ImportPaymentDefaultReqDto.class);

        return payment.getBody().getResponse();
    }

}
