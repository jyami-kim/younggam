package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.providerUser.ProviderUserReqDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.mapper.ProviderUserMapper;
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
    private final ProviderUserMapper providerUserMapper;

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

    private void checkUserIsAlreadyExisted(String email){
        Optional<ProviderUser> byEmail = providerUserMapper.findByEmail(email);
        if(byEmail.isPresent())
            throw new AlreadyUserException();
    }

    public void sendPasswordEmail(String email) {

    }

    public void editPassword(ProviderUser providerUser, String password) {

    }


}
