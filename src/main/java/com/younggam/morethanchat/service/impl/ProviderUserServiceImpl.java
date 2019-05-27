package com.younggam.morethanchat.service.impl;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.ProviderUserReqDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.service.ProviderUserService;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderUserServiceImpl implements ProviderUserService {

    private final ProviderUserRepository providerUserRepository;

    @Override
    @Transactional
    public void createUser(ProviderUserReqDto providerUserReqDto) throws AlreadyUserException {
        ProviderUser providerUser = ProviderUser.of(providerUserReqDto);
        checkUserIsAlreadyExisted(providerUser.getEmail());
        String passwordHashed = BCrypt.hashpw(providerUser.getPasswd(), BCrypt.gensalt());
        providerUser.setPasswd(passwordHashed);
        providerUserRepository.save(providerUser);
    }

    @Override
    public Optional<ProviderUser> getUserById(long id) {
        return providerUserRepository.findById(id);
    }

    @Override
    public ProviderUser checkEmailExist(String email) throws AlreadyUserException {
        return checkUserIsAlreadyExisted(email);
    }


    private ProviderUser checkUserIsAlreadyExisted(String email) throws AlreadyUserException {
        return providerUserRepository.findByEmail(email)
                .orElseThrow(AlreadyUserException::new);
    }


    @Override
    public void sendPasswordEmail(String email) {

    }

    @Override
    public void editPassword(ProviderUser providerUser, String password) {

    }


}
