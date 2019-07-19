package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.StoreService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
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
@RequestMapping("auth/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final JwtFactory jwtFactory;

    @RequestMapping(value = "/basicInfo", method = RequestMethod.POST, consumes =
            {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDto saveBasicInformation(AuthTokenDto authTokenDto,
                                            StoreBasicInfoReqDto storeBasicInfoReqDto,
                                            @RequestPart(value = "botImageFile", required = false) MultipartFile botImageFile) throws IOException {

        Long providerId = jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));

        if (botImageFile != null) storeBasicInfoReqDto.setBotImageFile(botImageFile);

        String botId = storeService.saveBasicInfo(providerId, storeBasicInfoReqDto);

        return ResponseDto.of(HttpStatus.OK, messageCode(SAVE_STORE_BASIC_INFO, botId));
    }

}
