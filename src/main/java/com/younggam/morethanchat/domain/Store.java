package com.younggam.morethanchat.domain;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Store {
    //TODO: 여기 확인하기

    @Id
    @Column(name = "provider_id")
    private Long providerUserId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="VEHICLE_ID", referencedColumnName="EXTRAS_ID")
    private ProviderUser provideruser;

    @NotNull
    private String name;

    private String description;

    @Column(name="phone_num")
    private String phoneNum;

    private String address;

    @Column(name="detailed_address")
    private String detailedAddress;

    @Column(name="business_day")
    private String businessDay;

    @Column(name="reservation_start")
    private String reservationStart;

    @Column(name="reservation_end")
    private String reservationEnd;

    @Column(name="early_reservation")
    private int earlyReservation;

    private String latitude;

    private String longitude;

    @Column(name="reg_date")
    private String regDate;

//    @UniqueElements
    @Column(name="bot_id")
    private String botId;

    @Column(name="bot_intro")
    private String botIntro;

    @Column(name="bot_image")
    private String botImage;

    @Builder(builderMethodName = "createBuilder")
    public Store(ProviderUser provideruser, @NotNull String name, String description, String phoneNum, String address, String detailedAddress, String businessDay, String reservationStart, String reservationEnd, int earlyReservation, String latitude, String longitude, String regDate, @UniqueElements String botId, String botIntro, String botImage) {
        this.providerUserId = provideruser.getId();
        this.provideruser = provideruser;
        this.name = name;
        this.description = description;
        this.phoneNum = phoneNum;
        this.address = address;
        this.detailedAddress = detailedAddress;
        this.businessDay = businessDay;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.earlyReservation = earlyReservation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.regDate = regDate;
        this.botId = botId;
        this.botIntro = botIntro;
        this.botImage = botImage;
    }
}
