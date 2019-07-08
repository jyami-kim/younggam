package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.providerUser.ProviderUserForgetEmailReqDto;
import com.younggam.morethanchat.dto.providerUser.ProviderUserForgetEmailResDto;
import com.younggam.morethanchat.dto.providerUser.ProviderUserForgetPassWdReqDto;
import com.younggam.morethanchat.dto.providerUser.ProviderUserReqDto;
import com.younggam.morethanchat.service.ProviderUserService;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class ProviderUserController {

    private final ProviderUserService providerUserService;

    @PostMapping("")
    public ResponseDto signUp(@RequestBody ProviderUserReqDto providerUserReqDto) {
        providerUserService.createUser(providerUserReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CREATED_USER);
    }

    @PostMapping("forget/id")
    public ResponseDto findForgetUserId(@RequestBody ProviderUserForgetEmailReqDto providerUserForgetEmailReqDto) {
        ProviderUserForgetEmailResDto providerUserEmail = providerUserService.findProviderUserEmail(providerUserForgetEmailReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.READ_USER, providerUserEmail);
    }

    @PostMapping("forget/passWd")
    public ResponseDto findForgetUserPassWd(@RequestBody ProviderUserForgetPassWdReqDto providerUserForgetPassWdReqDto) {
        providerUserService.canCheckProviderUserChangePassWd(providerUserForgetPassWdReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CAN_CHANGE_PASSWORD);
    }

    @PutMapping("forget/passWd")
    public ResponseDto updatePassword(@RequestBody ProviderUserForgetPassWdReqDto providerUserForgetPassWdReqDto) {
        providerUserService.canCheckProviderUserChangePassWd(providerUserForgetPassWdReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CAN_CHANGE_PASSWORD);
    }

//    @GetMapping("")
//    public ResponseDto emailCheck(@RequestParam(value = "email", defaultValue = "") final String email) {
//        try {
//            providerUserService.checkEmailExist(email);
//        } catch (AlreadyUserException e) {
//            return ResponseDto.of(HttpStatus.ALREADY_REPORTED, e.getMessage());
//        }
//        return ResponseDto.of(HttpStatus.OK, ResponseMessage.EMAIL_CHECK_SUCCESS);
//    }

//    @PostMapping("/auth")
//    public ResponseDto editPassword(@RequestBody String password, ){
//        TokenDto.of()
//    }
}
