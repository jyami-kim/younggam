package com.younggam.morethanchat.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Setter
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

    @NotNull
    @Setter
    @Column(name = "reg_date")
    private String regDate;

    @Column(name = "bot_id", unique = true)
    private String botId;

    @Setter
    @NotNull
    @Column(name = "start_time")
    private String startTime;

    @Setter
    @NotNull
    @Column(name = "end_time")
    private String endTime;


    @Setter
    @NotNull
    private boolean packing;

    @Setter
    @NotNull
    private boolean cool;

}
