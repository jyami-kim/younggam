package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.providerUser.ProviderUserReqDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderUserService {

    private final ProviderUserRepository providerUserRepository;

    @Transactional
    public Long createUser(ProviderUserReqDto providerUserReqDto){
        ProviderUser providerUser = providerUserReqDto.toEntity();
        checkUserIsAlreadyExisted(providerUser.getEmail());
        String passwordHashed = BCrypt.hashpw(providerUser.getPassWd(), BCrypt.gensalt());
        providerUser.setPassWd(passwordHashed);
        providerUser = providerUserRepository.save(providerUser);
        return providerUser.getId();
    }

    public Optional<ProviderUser> getUserById(long id) {
        return providerUserRepository.findById(id);
    }

    public ProviderUser checkEmailExist(String email) throws AlreadyUserException {
        return checkUserIsAlreadyExisted(email);
    }

    private ProviderUser checkUserIsAlreadyExisted(String email){
        return providerUserRepository.findByEmail(email)
                .orElseThrow(AlreadyUserException::new);
    }

    public void sendPasswordEmail(String email) {

    }

    public void editPassword(ProviderUser providerUser, String password) {

    }


}
