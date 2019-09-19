package com.younggam.morethanchat.dto.store;

import com.younggam.morethanchat.domain.RestDate;
import com.younggam.morethanchat.domain.Store;
import com.younggam.morethanchat.dto.store.restDate.RestDateReasonReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreBasicInfoReqDto {

    private String name;
    private String description;
    private String phoneNum;
    private String detailedAddress;
    private String startTime;
    private String endTime;
    private String reservationStart;
    private String reservationEnd;
    private boolean earlyReservation;
    private List<RestDateReasonReqDto> saveRestDates;
    private List<Long> deleteRestDates;

    public Store toStoreEntity(Long providerUserId, String botId) {
        return Store.builder()
                .providerId(providerUserId)
                .name(this.name)
                .description(this.description)
                .startTime(this.startTime)
                .endTime(this.endTime)
                .phoneNum(this.phoneNum)
                .detailedAddress(this.detailedAddress)
                .reservationStart(this.reservationStart)
                .reservationEnd(this.reservationEnd)
                .earlyReservation(this.earlyReservation)
                .botId(botId) //초기 생성시 botID는 랜덤값으로 부여! 이후 bot 생성하기에서 fix하기
                .regDate(getNowAllDate())
                .build();
    }


    public List<RestDate> toSaveRestDatesEntity(Long providerUserId) {
        return saveRestDates.stream()
                .map(c -> c.toEntity(providerUserId))
                .collect(Collectors.toList());
    }

    public Store toStoreEntityEdit(Store store) {
        store.setDescription(this.description);
        store.setReservationStart(this.reservationStart);
        store.setReservationEnd(this.reservationEnd);
        store.setEarlyReservation(this.earlyReservation);
        store.setPhoneNum(this.phoneNum);
        store.setDetailedAddress(this.detailedAddress);
        store.setRegDate(getNowAllDate());
        store.setStartTime(this.startTime);
        store.setEndTime(this.endTime);

        return store;
    }
}
