package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.providerUser.*;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.NotFoundUserException;
import com.younggam.morethanchat.mapper.ProviderUserMapper;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderUserService {

    private final ProviderUserRepository providerUserRepository;
    private final ProviderUserMapper providerUserMapper;

    private final JwtFactory jwtFactory;

    @Transactional
    public Long createUser(ProviderUserReqDto providerUserReqDto) {
        ProviderUser providerUser = providerUserReqDto.toEntity();
        checkUserIsAlreadyExisted(providerUserReqDto);
        String passwordHashed = BCrypt.hashpw(providerUser.getPassWd(), BCrypt.gensalt());
        providerUser.setPassWd(passwordHashed);
        providerUser = providerUserRepository.save(providerUser);
        return providerUser.getId();
    }

    public ProviderUserForgetEmailResDto findProviderUserEmail(ProviderUserForgetEmailReqDto providerUserForgetEmailReqDto) {
        ProviderUser providerUser = providerUserRepository
                .findByPhoneNumAndName(providerUserForgetEmailReqDto.getPhoneNum(), providerUserForgetEmailReqDto.getName())
                .orElseThrow(NotFoundUserException::new);
        return new ProviderUserForgetEmailResDto(providerUser.getEmail());
    }

    public String canCheckProviderUserChangePassWd(ProviderUserForgetPassWdReqDto providerUserForgetPassWdReqDto) {
        ProviderUser providerUser = providerUserRepository
                .findByPhoneNumAndEmail(providerUserForgetPassWdReqDto.getPhoneNum(), providerUserForgetPassWdReqDto.getEmail())
                .orElseThrow(NotFoundUserException::new);

        return jwtFactory.generatePasswordToken(providerUser);
    }

    public void checkUserEmail(String email) {
        Optional<ProviderUser> byEmail = providerUserRepository.findByEmail(email);
        if (byEmail.isPresent())
            throw new AlreadyUserException(ResponseMessage.ALREADY_EXISTED_EMAIL);
    }

    private void checkUserIsAlreadyExisted(ProviderUserReqDto providerUserReqDto) {
        Optional<ProviderUser> existUser = providerUserMapper.findExistUser(providerUserReqDto.getPhoneNum(),
                providerUserReqDto.getEmail());
        if (existUser.isPresent())
            throw new AlreadyUserException(ResponseMessage.ALREADY_EXISTED_USER);
    }

    public Long updateProviderUserUpdatePassword(ProviderUserChangePasswordReqDto providerUserChangePasswordReqDto, Long providerId){
        ProviderUser providerUser = providerUserRepository.findById(providerId)
                .orElseThrow(NotFoundUserException::new);

        providerUser.setPassWd(providerUserChangePasswordReqDto.getPassWd());

        providerUser = providerUserRepository.save(providerUser);
        return providerUser.getId();
    }

    public Optional<ProviderUser> getUserById(long id) {
        return providerUserRepository.findById(id);
    }

}
