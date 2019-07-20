package com.younggam.morethanchat.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Store {

    @Id
    @Column(name = "provider_id")
    private Long providerId;

    @NotNull
    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    @Column(name = "phone_num")
    private String phoneNum;

    private String address;

    @Column(name = "detailed_address")
    private String detailedAddress;

    @Setter
    @Column(name = "business_day")
    private String businessDay;

    @Setter
    @Column(name = "reservation_start")
    private String reservationStart;

    @Setter
    @Column(name = "reservation_end")
    private String reservationEnd;

    @Setter
    @Column(name = "early_reservation")
    private boolean earlyReservation;


    private String latitude;

    private String longitude;

    @NotNull
    @Setter
    @Column(name = "reg_date")
    private String regDate;


    @Column(name = "bot_id", unique = true)
    private String botId;

    @Setter
    @Column(name = "bot_intro")
    private String botIntro;

    @Setter
    @Column(name = "bot_image")
    private String botImage;

}
