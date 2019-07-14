package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.repository.StoreRepository;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_USER;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProviderUserRepository providerUserRepository;

    private void checkCreateNewStoreIsAlreadyExisted(Long providerId){
        Optional<Store> alreadyStore = storeRepository.findById(providerId);
        if(alreadyStore.isPresent())
            throw new AlreadyUserException(ResponseMessage.ALREADY_EXISTED_STORE);
    }

    @Transactional
    public String saveBasicInfo(Long providerId, StoreBasicInfoReqDto storeBasicInfoReqDto){
        checkCreateNewStoreIsAlreadyExisted(providerId);
        ProviderUser providerUser = providerUserRepository.findById(providerId).orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));
        Store store = storeBasicInfoReqDto.toEntity(providerUser);
        store = storeRepository.save(store);
        return store.getBotId();
    }

}
