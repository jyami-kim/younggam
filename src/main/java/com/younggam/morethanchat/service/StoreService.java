package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoResDto;
import com.younggam.morethanchat.dto.store.StoreBasicInfoSaveResDto;
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

import static com.younggam.morethanchat.utils.ResponseMessage.ALREADY_EXISTED_STORE;
import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService {

    private final StoreRepository storeRepository;
    private final ProviderUserRepository providerUserRepository;
    private final FileUploadService fileUploadService;

    public StoreBasicInfoResDto getBasicInfo(Long providerId) {

        ProviderUser providerUser = providerUserRepository.findById(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));

        Store store = storeRepository.findById(providerId)
                .orElseThrow(() -> new EmptyException(ALREADY_EXISTED_STORE));

        return new StoreBasicInfoResDto(store);

    }

    @Transactional
    public StoreBasicInfoSaveResDto saveBasicInfo(Long providerId, StoreBasicInfoReqDto storeBasicInfoReqDto) throws IOException {
        ProviderUser providerUser = providerUserRepository.findById(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_USER));

        checkCreateNewStoreIsAlreadyExisted(providerId);

        if (storeBasicInfoReqDto.getBotImageFile() != null)
            storeBasicInfoReqDto.setBotImage(fileUploadService.upload(storeBasicInfoReqDto.getBotImageFile()));

        Store store = storeBasicInfoReqDto.toEntity(providerUser);
        store = storeRepository.save(store);
        return new StoreBasicInfoSaveResDto(store);
    }

    private boolean checkCreateNewStoreIsAlreadyExisted(Long providerId) {
        Optional<Store> alreadyStore = storeRepository.findById(providerId);
        return alreadyStore.isPresent();
    }


}
