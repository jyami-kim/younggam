package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.RestDate;
import com.younggam.morethanchat.dto.store.StoreBasicInfoReqDto;
import com.younggam.morethanchat.mapper.RestDateMapper;
import com.younggam.morethanchat.repository.RestDateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestDateService {
    private final RestDateRepository restDateRepository;
    private final RestDateMapper restDateMapper;

    @Transactional
    public void saveRestDate(Long providerId, StoreBasicInfoReqDto storeBasicInfoReqDto) {
        if (storeBasicInfoReqDto.getSaveRestDates().size() != 0) {
            List<RestDate> byProviderId = restDateRepository.findByProviderId(providerId);
            storeBasicInfoReqDto.getSaveRestDates().removeAll(byProviderId);
//            List<RestDate> byProviderId = restDateRepository.findByProviderId(providerId);
            List<RestDate> restDates = storeBasicInfoReqDto.toSaveRestDatesEntity(providerId);
            restDateRepository.saveAll(restDates);
        }
    }

    @Transactional
    public void deleteRestDate(StoreBasicInfoReqDto storeBasicInfoReqDto) {
        if (storeBasicInfoReqDto.getDeleteRestDates().size() != 0) {
            List<RestDate> allById = restDateRepository.findAllById(storeBasicInfoReqDto.getDeleteRestDates());
            restDateRepository.deleteAll(allById);
        }
    }

    public List<RestDate> getRestDates(Long providerId) {
        return restDateRepository.findByProviderId(providerId);
    }


}
