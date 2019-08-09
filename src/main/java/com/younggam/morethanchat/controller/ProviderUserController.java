package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.TokenDto;
import com.younggam.morethanchat.dto.providerUser.*;
import com.younggam.morethanchat.exception.CustomAuthException;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.ProviderUserService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Slf4j
public class ProviderUserController {

    private final ProviderUserService providerUserService;
    private final JwtFactory jwtFactory;

    @PostMapping("")
    public ResponseDto signUp(@RequestBody ProviderUserReqDto providerUserReqDto) {
        Long providerUserId = providerUserService.createUser(providerUserReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CREATED_USER, providerUserId);
    }

    @GetMapping("/check")
    public ResponseDto checkEmailExisted(@RequestParam(name = "email") String email) {
        providerUserService.checkUserEmail(email);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.EMAIL_CHECK_SUCCESS);
    }

    @PostMapping("forget/id")
    public ResponseDto findForgetUserId(@RequestBody ProviderUserForgetEmailReqDto providerUserForgetEmailReqDto) {
        ProviderUserForgetEmailResDto providerUserEmail = providerUserService.findProviderUserEmail(providerUserForgetEmailReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.READ_USER, providerUserEmail);
    }

    @PostMapping("forget/passWd")
    public ResponseDto findForgetUserPassWd(@RequestBody ProviderUserForgetPassWdReqDto providerUserForgetPassWdReqDto) {
        String passToken = providerUserService.canCheckProviderUserChangePassWd(providerUserForgetPassWdReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CAN_CHANGE_PASSWORD, passToken);
    }

    @PutMapping("pass")
    public ResponseDto updatePassword(TokenDto tokenDto,
                                      @RequestBody ProviderUserChangePasswordReqDto providerUserChangePasswordReqDto) throws CustomAuthException {
        Long providerId = jwtFactory.getUserId(tokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.PASSWORD_TOKEN_ERROR));

        Long providerUserId = providerUserService.updateProviderUserUpdatePassword(providerUserChangePasswordReqDto, providerId);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.UPDATE_USER, providerUserId);
    }

    @GetMapping("/my")
    public ResponseDto getUserById(AuthTokenDto authTokenDto) {
        Long providerId = jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.PASSWORD_TOKEN_ERROR));

        return ResponseDto.of(HttpStatus.OK, ResponseMessage.READ_USER, providerUserService.getUserById(providerId));
    }

}
