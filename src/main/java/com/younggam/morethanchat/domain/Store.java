package com.younggam.morethanchat.domain;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Store {

    @Id
    @Column(name="provider_id")
    private Long providerId;

    @OneToOne
    @JoinColumn(name = "provider_id")
    @MapsId
    private ProviderUser providerUser;

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

}
