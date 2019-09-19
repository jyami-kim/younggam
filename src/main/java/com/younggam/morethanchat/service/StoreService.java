package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoResDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.EmptyException;
import com.younggam.morethanchat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

import static com.younggam.morethanchat.utils.ResponseMessage.CHAT_NAME_IS_ALREADY_EXIST;
import static com.younggam.morethanchat.utils.ResponseMessage.FIRST_FORMAT_STORE;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService {

    private final StoreRepository storeRepository;
//    private final FileUploadService fileUploadService;

    public StoreBasicInfoResDto getBasicInfo(Long providerId) {
        Store store = storeRepository.findById(providerId)
                .orElseThrow(() -> new EmptyException(FIRST_FORMAT_STORE));
        return new StoreBasicInfoResDto(store);
    }


    @Transactional
    public Long saveStoreBasicInfo(Long providerId, StoreBasicInfoReqDto storeBasicInfoReqDto) {
        Store store = new Store();

        Optional<Store> alreadyStore = storeRepository.findByProviderId(providerId);

        if (alreadyStore.isPresent()) { //수정
            if (!storeBasicInfoReqDto.getName().equals(alreadyStore.get().getName())) {
                checkNameIsUnique(storeBasicInfoReqDto.getName());
            }
            store = storeBasicInfoReqDto.toStoreEntityEdit(alreadyStore.get());
        } else { //새로 만들기
            String botId;
            checkNameIsUnique(storeBasicInfoReqDto.getName());
            do {
                botId = storeBasicInfoReqDto.getName() + new Random().nextInt(100);
            } while (checkBotIdIsNotUnique(botId));
            store = storeBasicInfoReqDto.toStoreEntity(providerId, botId);
        }
        store = storeRepository.save(store);
        return store.getProviderId();
    }

    public void checkNameIsUnique(String name) {
        storeRepository.findByName(name).ifPresent(x -> {
            throw new AlreadyUserException(CHAT_NAME_IS_ALREADY_EXIST);
        });
    }

    private boolean checkBotIdIsNotUnique(String botId) {
        return storeRepository.findByBotId(botId).isPresent();
    }

}
