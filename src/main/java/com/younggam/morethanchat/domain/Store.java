package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Store {

    @NotNull
    @Column(name = "provider_id")
    private Long providerId;

    @NotNull
    private String name;

    private String description;

    @Column(name = "phone_num")
    private String phoneNum;

    private String address;

    @Column(name = "detailed_address")
    private String detailedAddress;

    @Column(name = "business_day")
    private String businessDay;

    @Column(name = "reservation_start")
    private String reservationStart;

    @Column(name = "reservation_end")
    private String reservationEnd;

    @Column(name = "early_reservation")
    private int earlyReservation;

    private String latitude;

    private String longitude;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    @Column(name = "bot_id", unique = true)
    private String botId;

    @NotNull
    @Column(name = "bot_intro")
    private String botIntro;

    @NotNull
    @Column(name = "bot_image")
    private String botImage;

}
