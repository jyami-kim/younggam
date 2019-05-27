package com.younggam.morethanchat.service;

import com.younggam.morethanchat.dto.LoginReqDto;
import com.younggam.morethanchat.dto.ProviderUserReqDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.exception.LoginFailException;

public interface LoginService {
    String login(LoginReqDto loginReqDto) throws LoginFailException;
}
