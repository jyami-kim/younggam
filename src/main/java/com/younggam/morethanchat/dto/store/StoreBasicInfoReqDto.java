package com.younggam.morethanchat.dto.store;

import com.younggam.morethanchat.domain.ProviderUser;
import com.younggam.morethanchat.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;

import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreBasicInfoReqDto {

    private String name;
    private String description;
    private String phoneNum;
    private String businessDay;
    private String reservationStart;
    private String reservationEnd;
    private boolean earlyReservation;
    private String botIntro;
    @Setter
    private MultipartFile botImageFile; //이미지 사진 객체
    @Setter
    private String botImage; //이미지 사진 저장 url 주소

    public Store toEntity(ProviderUser providerUser, String botId) {
        return Store.builder()
                .providerId(providerUser.getId())
                .name(this.name)
                .description(this.description)
                .phoneNum(this.phoneNum)
                .businessDay(this.businessDay)
                .reservationStart(this.reservationStart)
                .reservationEnd(this.reservationEnd)
                .earlyReservation(this.earlyReservation)
                .botId(botId) //초기 생성시 botID는 랜덤값으로 부여! 이후 bot 생성하기에서 fix하기
                .botIntro(this.botIntro)
                .botImage(this.botImage)
                .regDate(getNowAllDate())
                .build();
    }

    public Store toEntityEdit(Store store){
        store.setBotImage(this.botImage);
        store.setBotIntro(this.botIntro);
        store.setBusinessDay(this.businessDay);
        store.setDescription(this.description);
        store.setReservationStart(this.reservationStart);
        store.setReservationEnd(this.reservationEnd);
        store.setEarlyReservation(this.earlyReservation);
        store.setPhoneNum(this.phoneNum);
        store.setRegDate(getNowAllDate());
        return store;
    }
}
