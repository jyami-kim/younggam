package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.PdfDownloaderUser;
import com.younggam.morethanchat.dto.additional.PdfDownloaderUserReqDto;
import com.younggam.morethanchat.repository.PdfDownloaderUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DownloadService {
    private final PdfDownloaderUserRepository pdfDownloaderUserRepository;

    @Value("${pdf.service.propose}")
    private String serviceProposeUrl;

    @Transactional
    public String saveInfoAndGetServiceProposeDocument(PdfDownloaderUserReqDto pdfDownloaderUserReqDto){
        PdfDownloaderUser pdfDownloaderUser = pdfDownloaderUserReqDto.toEntity();
        PdfDownloaderUser save = pdfDownloaderUserRepository.save(pdfDownloaderUser);
        log.info(save.getEmail() + "이 서비스 제안서를 다운로드 했습니다.");
        return serviceProposeUrl;
    }
}
