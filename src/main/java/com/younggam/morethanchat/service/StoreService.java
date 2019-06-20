package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.exception.NotFoundUserException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProviderUserRepository providerUserRepository;

    public String saveBasicInfo(Long providerId, StoreBasicInfoReqDto storeBasicInfoReqDto){
        ProviderUser providerUser = providerUserRepository.findById(providerId).orElseThrow(NotFoundUserException::new);
        Store store = storeBasicInfoReqDto.toEntity(providerUser);
        store = storeRepository.save(store);
        return store.getBotId();
    }
}
