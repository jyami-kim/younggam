package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.providerUser.LoginReqDto;
import com.younggam.morethanchat.exception.AuthException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final ProviderUserRepository providerUserRepository;
    private final JwtFactory jwtFactory;

    public String login(LoginReqDto loginReqDto) {
        ProviderUser providerUser = providerUserRepository.findByEmail(loginReqDto.getEmail())
                .orElseThrow(() -> new AuthException(ResponseMessage.LOGIN_FAIL));
        if (!BCrypt.checkpw(loginReqDto.getPassWd(), providerUser.getPassWd()))
            throw new AuthException(ResponseMessage.LOGIN_FAIL);
        return jwtFactory.generateToken(providerUser);
    }
}
