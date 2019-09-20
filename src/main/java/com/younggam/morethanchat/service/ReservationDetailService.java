package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.ChatBotSettings;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.reservation.ReservationReqDto;
import com.younggam.morethanchat.dto.reservation.ReservationResDto;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.repository.ChatBotSettingsRepository;
import com.younggam.morethanchat.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_RESERVATION_DETAIL;
import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_STORE;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationDetailService {

    private final ChatBotSettingsRepository chatBotSettingsRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Long reservationDetailSave(Long providerId, ReservationReqDto reservationReqDto) {
        ChatBotSettings chatBotSettings = chatBotSettingsRepository.findByProviderId(providerId);
        ChatBotSettings chatBotSettingsSave;

        Store store = storeRepository.findByProviderId(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_STORE));

        if (chatBotSettings == null) {
            chatBotSettingsSave = reservationReqDto.toChatBotSettingsEntity(providerId);
        } else {
            chatBotSettingsSave = reservationReqDto.toChatBotSettingsEdit(chatBotSettings);
        }
        store.setCoolPackingMessage(reservationReqDto.getCoolPackingMessage());
        ChatBotSettings save = chatBotSettingsRepository.save(chatBotSettingsSave);
        return save.getProviderId();
    }

    public ReservationResDto getReservationDetail(Long providerId) {
        ChatBotSettings chatBotSettings = chatBotSettingsRepository.findByProviderId(providerId);
        Store store = storeRepository.findByProviderId(providerId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_STORE));
        if (chatBotSettings == null) {
            throw new NotFoundException(NOT_FOUND_RESERVATION_DETAIL);
        }
        return new ReservationResDto(chatBotSettings, store.getCoolPackingMessage());
    }
}
