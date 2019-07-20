package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoResDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoSaveResDto;
import com.younggam.morethanchat.exception.AlreadyUserException;
import com.younggam.morethanchat.exception.EmptyException;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.repository.ProviderUserRepository;
import com.younggam.morethanchat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import static com.younggam.morethanchat.utils.ResponseMessage.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProviderUserRepository providerUserRepository;
    private final FileUploadService fileUploadService;

    public StoreBasicInfoResDto getBasicInfo(Long providerId) {
        providerUserCheck(providerId);
        Store store = storeRepository.findById(providerId)
                .orElseThrow(() -> new EmptyException(ALREADY_EXISTED_STORE));
        return new StoreBasicInfoResDto(store);
    }

    @Transactional
    public StoreBasicInfoSaveResDto saveBasicInfo(Long providerId, StoreBasicInfoReqDto storeBasicInfoReqDto) throws IOException {
        ProviderUser providerUser = providerUserCheck(providerId);

        Store store = new Store();

        Optional<Store> alreadyStore = storeRepository.findByProviderId(providerId);

        if (storeBasicInfoReqDto.getBotImageFile() != null)
            storeBasicInfoReqDto.setBotImage(fileUploadService.upload(storeBasicInfoReqDto.getBotImageFile()));

        if (alreadyStore.isPresent()) { //수정
            if (storeBasicInfoReqDto.getBotImageFile() == null)
                storeBasicInfoReqDto.setBotImage(alreadyStore.get().getBotImage());
            if (!storeBasicInfoReqDto.getName().equals(alreadyStore.get().getName())) {
                checkNameIsUnique(storeBasicInfoReqDto.getName());
            }
            store = storeBasicInfoReqDto.toEntityEdit(alreadyStore.get());
        } else { //새로 만들기
            String botId;
            checkNameIsUnique(storeBasicInfoReqDto.getName());
            do {
                botId = storeBasicInfoReqDto.getName() + new Random().nextInt(100);
            } while (checkBotIdIsNotUnique(botId));
            store = storeBasicInfoReqDto.toEntity(providerUser, botId);
        }
        store = storeRepository.save(store);

        return new StoreBasicInfoSaveResDto(store);
    }

    public void checkNameIsUnique(String name, Long providerId) {
        providerUserCheck(providerId);
        checkNameIsUnique(name);
    }

    private void checkNameIsUnique(String name) {
        storeRepository.findByName(name).ifPresent(x -> {
            throw new AlreadyUserException(CHAT_NAME_IS_ALREADY_EXIST);
        });
    }

    private boolean checkBotIdIsNotUnique(String botId) {
        return storeRepository.findByBotId(botId).isPresent();
    }

    private ProviderUser providerUserCheck(Long providerId) {
        return providerUserRepository.findById(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));
    }

}
