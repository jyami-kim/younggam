package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.domain.RestDate;
import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoResDto;
import com.younggam.morethanchat.service.RestDateService;
import com.younggam.morethanchat.service.StoreService;
import com.younggam.morethanchat.utils.JwtFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.younggam.morethanchat.utils.ResponseMessage.*;

@RestController
@Slf4j
@RequestMapping("auth/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final RestDateService restDateService;
    private final JwtFactory jwtFactory;

    @GetMapping("basicInfo")
    public ResponseDto getBasicInformation(AuthTokenDto authTokenDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);
        StoreBasicInfoResDto basicInfo = storeService.getBasicInfo(providerId);
        return ResponseDto.of(HttpStatus.OK, READ_STORE_BASIC_INFO_SUCCESS, basicInfo);
    }

    @PostMapping("/basicInfo")
//    @RequestMapping(value = "/basicInfo", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseDto saveBasicInformation(AuthTokenDto authTokenDto,
                                            @RequestBody StoreBasicInfoReqDto storeBasicInfoReqDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);

        Long storeProviderId = storeService.saveStoreBasicInfo(providerId, storeBasicInfoReqDto);
        restDateService.deleteRestDate(storeBasicInfoReqDto);
        restDateService.saveRestDate(providerId, storeBasicInfoReqDto);

        return ResponseDto.of(HttpStatus.OK, SAVE_STORE_BASIC_INFO, storeProviderId);
    }


    @GetMapping("/basicInfo/restDate")
    public ResponseDto getRestDate(AuthTokenDto authTokenDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);

        List<RestDate> restDates = restDateService.getRestDates(providerId);
        return ResponseDto.of(HttpStatus.OK, READ_STORE_REST_DATE_SUCCESS, restDates);
    }

    @GetMapping()
    public ResponseDto checkIfNameExisted(AuthTokenDto authTokenDto, @RequestParam String name) {
        jwtFactory.checkAuth(authTokenDto);
        storeService.checkNameIsUnique(name);
        return ResponseDto.of(HttpStatus.OK, CHAT_NAME_IS_UNIQUE);
    }
}
