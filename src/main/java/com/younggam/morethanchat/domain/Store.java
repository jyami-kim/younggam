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
    @Column(name = "providerId")
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
    @NotNull
    @Column(name = "business_day")
    private String businessDay;

    @Setter
    @NotNull
    @Column(name = "reservation_start")
    private String reservationStart;

    @Setter
    @NotNull
    @Column(name = "reservation_end")
    private String reservationEnd;

    @Setter
    @NotNull
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
    @NotNull
    @Column(name = "bot_intro")
    private String botIntro;

    @Setter
    @NotNull
    @Column(name = "bot_image")
    private String botImage;

    @NotNull
    private boolean packing;

    @NotNull
    private boolean cool;

}
