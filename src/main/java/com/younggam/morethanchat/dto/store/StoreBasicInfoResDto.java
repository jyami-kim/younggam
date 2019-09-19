package com.younggam.morethanchat.dto.store;

import com.younggam.morethanchat.domain.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StoreBasicInfoResDto {
    private String name;
    private String description;
    private String phoneNum;

    private String detailedAddress;
    private String startTime;
    private String endTime;

    private String reservationStart;
    private String reservationEnd;
    private boolean earlyReservation;

    public StoreBasicInfoResDto(Store store) {
        this.name = store.getName();
        this.description = store.getDescription();
        this.phoneNum = store.getPhoneNum();
        this.detailedAddress = store.getDetailedAddress();
        this.startTime = store.getStartTime();
        this.endTime = store.getEndTime();
        this.reservationStart = store.getReservationStart();
        this.reservationEnd = store.getReservationEnd();
        this.earlyReservation = store.isEarlyReservation();
    }
}
