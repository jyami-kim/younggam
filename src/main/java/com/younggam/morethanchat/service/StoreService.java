package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.NotFoundUserException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.younggam.morethanchat.utils.ResponseMessage.STORE_BASIC_INFO_IS_ALREADY_EXIST;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProviderUserRepository providerUserRepository;

    private void checkCreateNewStoreIsAlreadyExisted(Long providerId){
        Optional<Store> alreadyStore = storeRepository.findById(providerId);
        if(alreadyStore.isPresent())
            throw new AlreadyUserException(STORE_BASIC_INFO_IS_ALREADY_EXIST);
        //이경우에는 post가 아니라 put 연산을 해야함! 그래서 front에게 알려주는!
    }

    @Transactional
    public String saveBasicInfo(Long providerId, StoreBasicInfoReqDto storeBasicInfoReqDto){
        checkCreateNewStoreIsAlreadyExisted(providerId);
        ProviderUser providerUser = providerUserRepository.findById(providerId).orElseThrow(NotFoundUserException::new);
        Store store = storeBasicInfoReqDto.toEntity(providerUser);
        store = storeRepository.save(store);
        return store.getBotId();
    }


}
