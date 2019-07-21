package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoResDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoSaveResDto;
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

import static com.younggam.morethanchat.utils.ResponseMessage.*;
import static com.younggam.morethanchat.utils.TypeConverter.stringToStoreBasicInfoReqDto;

@RestController
@Slf4j
@RequestMapping("auth/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final JwtFactory jwtFactory;

    @GetMapping("basicInfo")
    public ResponseDto getBasicInformation(AuthTokenDto authTokenDto) {
        Long providerId = checkAuth(authTokenDto);
        StoreBasicInfoResDto basicInfo = storeService.getBasicInfo(providerId);
        return ResponseDto.of(HttpStatus.OK, READ_STORE_BASIC_INFO_SUCCESS, basicInfo);
    }

    @RequestMapping(value = "/basicInfo", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDto saveBasicInformation(AuthTokenDto authTokenDto,
                                            @RequestPart String storeBasicInfoReqDtoString,
                                            @RequestPart(value = "botImageFile", required = false) MultipartFile botImageFile) throws IOException {
        Long providerId = checkAuth(authTokenDto);
        StoreBasicInfoReqDto storeBasicInfoReqDto = stringToStoreBasicInfoReqDto(storeBasicInfoReqDtoString);

        if (botImageFile != null)
            storeBasicInfoReqDto.setBotImageFile(botImageFile);

        StoreBasicInfoSaveResDto storeBasicInfoSaveResDto = storeService.saveBasicInfo(providerId, storeBasicInfoReqDto);

        return ResponseDto.of(HttpStatus.OK, SAVE_STORE_BASIC_INFO, storeBasicInfoSaveResDto);
    }

    @GetMapping()
    public ResponseDto checkIfNameExisted(AuthTokenDto authTokenDto, @RequestParam String name) {
        checkAuth(authTokenDto);
        storeService.checkNameIsUnique(name);
        return ResponseDto.of(HttpStatus.OK, CHAT_NAME_IS_UNIQUE);
    }

    private Long checkAuth(AuthTokenDto authTokenDto) {
        return jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));
    }
}
