package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.TokenDto;
import com.younggam.morethanchat.dto.providerUser.*;
import com.younggam.morethanchat.service.ProviderUserService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class ProviderUserController {

    private final ProviderUserService providerUserService;
    private final JwtFactory jwtFactory;

    @PostMapping("")
    public ResponseDto signUp(@RequestBody ProviderUserReqDto providerUserReqDto) {
        providerUserService.createUser(providerUserReqDto);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CREATED_USER);
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
                                      @RequestBody ProviderUserChangePasswordReqDto providerUserChangePasswordReqDto) throws AuthException {
        Long providerId = jwtFactory.getUserId(tokenDto.getToken())
                .orElseThrow(() -> new AuthException(ResponseMessage.PASSWORD_TOKEN_ERROR));

        Long providerUserId = providerUserService.updateProviderUserUpdatePassword(providerUserChangePasswordReqDto, providerId);
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CAN_CHANGE_PASSWORD, providerUserId);
    }

    // TODO: auth 체크 안된상태로 그냥 id가 호출 될 수 있어서 관리자 권한에서만 가능하게 수정해야함.
    @GetMapping("/{id}")
    public ResponseDto getUserById(@PathVariable(name = "id") Long id) {
        return ResponseDto.of(HttpStatus.OK, ResponseMessage.CREATED_USER, providerUserService.getUserById(id));
    }


}
