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
    private String businessDay;
    private String reservationStart;
    private String reservationEnd;
    private boolean earlyReservation;
    private String botIntro;
    private String botImage; //이미지 사진 저장 url 주소

    public StoreBasicInfoResDto(Store store) {
        this.name = store.getName();
        this.description = store.getDescription();
        this.phoneNum = store.getPhoneNum();
        this.businessDay = store.getBusinessDay();
        this.reservationStart = store.getReservationStart();
        this.reservationEnd = store.getReservationEnd();
        this.earlyReservation = store.isEarlyReservation();
        this.botImage = store.getBotImage();
        this.botIntro = store.getBotIntro();
    }
}
