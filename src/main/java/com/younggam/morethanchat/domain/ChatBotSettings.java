package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "chatbot_settins")
@AllArgsConstructor
public class ChatBotSettings {
    @NotNull
    @Column(name = "providerId")
    private Long providerId;
    @NotNull
    @Column(name = "pm_morethan")
    private boolean pmMoreThan;
    @NotNull
    @Column(name = "pm_place")
    private boolean pmPlace;
    @NotNull
    @Column(name = "pm_account")
    private boolean pmAccount;
    @NotNull
    @Column(name = "reservation_date")
    private boolean reservationDate;
    @NotNull
    @Column(name = "reservation_cancel")
    private boolean reservationCancel;
    @NotNull
    @Column(name = "wrapping_service")
    private boolean wrappingService;
    @NotNull
    @Column(name = "reg_date")
    private String reg_date;

}
