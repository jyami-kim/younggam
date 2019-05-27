package com.younggam.morethanchat.service.impl;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.LoginReqDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.exception.LoginFailException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.service.LoginService;
import com.younggam.morethanchat.utils.JwtFactory;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final ProviderUserRepository providerUserRepository;
    private final JwtFactory jwtFactory;

    @Override
    public String login(LoginReqDto loginReqDto) throws LoginFailException {
        ProviderUser providerUser = providerUserRepository.findByEmail(loginReqDto.getEmail())
                .orElseThrow(LoginFailException::new);
        if(!BCrypt.checkpw(loginReqDto.getPasswd(), providerUser.getPasswd()))
            throw new LoginFailException();
        return jwtFactory.generateToken(providerUser);

    }
}
