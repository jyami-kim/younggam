package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.dto.ProviderUserReqDto;
import com.younggam.morethanchat.exception.AlreadyUserException;

import java.util.Optional;


public interface ProviderUserService {

    void createUser(ProviderUserReqDto providerUserReqDto) throws AlreadyUserException;
    Optional<ProviderUser> getUserById(long id);
    ProviderUser checkEmailExist(String email) throws AlreadyUserException;
    void sendPasswordEmail(String email);
    void editPassword(ProviderUser providerUser, String password);
}
