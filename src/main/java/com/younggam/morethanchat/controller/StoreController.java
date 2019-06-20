package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.younggam.morethanchat.utils.ResponseMessage.*;

@RestController
@Slf4j
@RequestMapping("/auth/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("basicInfo")
    public ResponseDto saveBasicInformation(@RequestAttribute Long providerId, @RequestBody StoreBasicInfoReqDto storeBasicInfoReqDto){
        String botId = storeService.saveBasicInfo(providerId, storeBasicInfoReqDto);
        return ResponseDto.of(HttpStatus.OK, messageCode(SAVE_STORE_BASIC_INFO, botId));
    }

}
