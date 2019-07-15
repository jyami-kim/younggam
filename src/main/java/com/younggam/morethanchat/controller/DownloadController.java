package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.download.PdfDownloaderUserReqDto;
import com.younggam.morethanchat.service.DownloadService;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/pdf/document")
@RequiredArgsConstructor
public class DownloadController {

    private final DownloadService downloadService;

    @PostMapping("")
    public ResponseDto saveDownLoaderUserInfo(@RequestBody PdfDownloaderUserReqDto pdfDownloaderUserReqDto) {
        String downloadUrl = downloadService.saveInfoAndGetServiceProposeDocument(pdfDownloaderUserReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.SAVE_PDF_DOWNLOADER_USER_SUCCESS, downloadUrl);
    }

}
