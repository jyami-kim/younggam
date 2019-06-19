package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.store.StoreReqDto;
import com.younggam.morethanchat.service.StoreService;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.younggam.morethanchat.utils.ResponseMessage.*;

@Controller
@Slf4j
@RequestMapping("/auth/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("basicInfo")
    public ResponseDto saveBasicInformation(@RequestAttribute Long providerId, @RequestBody StoreReqDto storeReqDto){
        String botId = storeService.saveBasicInfo(providerId, storeReqDto);
        return ResponseDto.of(HttpStatus.OK, messageCode(SAVE_STORE_BASIC_INFO, botId));
    }

}
