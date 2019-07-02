package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.providerUser.LoginReqDto;
import com.younggam.morethanchat.exception.LoginFailException;
import com.younggam.morethanchat.mapper.ProviderUserMapper;
import com.younggam.morethanchat.utils.JwtFactory;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final ProviderUserMapper providerUserMapper;
    private final JwtFactory jwtFactory;

    public String login(LoginReqDto loginReqDto) {
        ProviderUser providerUser = providerUserMapper.findByEmail(loginReqDto.getEmail())
                .orElseThrow(LoginFailException::new);
        if (!BCrypt.checkpw(loginReqDto.getPassWd(), providerUser.getPassWd()))
            throw new LoginFailException();
        return jwtFactory.generateToken(providerUser);

    }
}
