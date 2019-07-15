package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.providerUser.*;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.mapper.ProviderUserMapper;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_USER;

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
        return setPassword(providerUserReqDto.getPassWd(), providerUser);
    }

    public ProviderUserForgetEmailResDto findProviderUserEmail(ProviderUserForgetEmailReqDto providerUserForgetEmailReqDto) {
        ProviderUser providerUser = providerUserMapper
                .findExistUserByPhoneNumAndName(providerUserForgetEmailReqDto.getPhoneNum(), providerUserForgetEmailReqDto.getName())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));
        return new ProviderUserForgetEmailResDto(providerUser.getEmail());
    }

    public String canCheckProviderUserChangePassWd(ProviderUserForgetPassWdReqDto providerUserForgetPassWdReqDto) {
        ProviderUser providerUser = providerUserMapper
                .findExistUserByPhoneNumAndEmail(providerUserForgetPassWdReqDto.getPhoneNum(), providerUserForgetPassWdReqDto.getEmail())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));

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

    @Transactional
    public Long updateProviderUserUpdatePassword(ProviderUserChangePasswordReqDto providerUserChangePasswordReqDto, Long providerId) {
        ProviderUser providerUser = providerUserRepository.findById(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));
        return setPassword(providerUserChangePasswordReqDto.getPassWd(), providerUser);
    }

    public ProviderUserResDto getUserById(Long providerId) {
        ProviderUser providerUser = providerUserRepository.findById(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));

        return new ProviderUserResDto(providerUser);
    }

    private Long setPassword(String passWord, ProviderUser providerUser) {
        String passwordHashed = BCrypt.hashpw(passWord, BCrypt.gensalt());
        providerUser.setPassWd(passwordHashed);
        providerUser = providerUserRepository.save(providerUser);
        return providerUser.getId();
    }

}
