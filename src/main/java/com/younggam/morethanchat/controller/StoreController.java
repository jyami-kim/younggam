package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.younggam.morethanchat.utils.ResponseMessage.SAVE_STORE_BASIC_INFO;
import static com.younggam.morethanchat.utils.ResponseMessage.messageCode;

@RestController
@Slf4j
@RequestMapping("/auth/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @RequestMapping(value = "/basicInfo", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDto saveBasicInformation(@RequestAttribute Long providerId,
                                            @RequestPart(value = "storeBasicInfo") StoreBasicInfoReqDto storeBasicInfoReqDto,
                                            @RequestPart(value = "botImageFile", required = false) MultipartFile botImageFile) throws IOException {
        if (botImageFile != null) storeBasicInfoReqDto.setBotImageFile(botImageFile);

        String botId = storeService.saveBasicInfo(providerId, storeBasicInfoReqDto);

        return ResponseDto.of(HttpStatus.OK, messageCode(SAVE_STORE_BASIC_INFO, botId));
    }

}
