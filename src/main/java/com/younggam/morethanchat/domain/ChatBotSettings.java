package com.younggam.morethanchat.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "chatbot_settings")
@AllArgsConstructor
@Builder
@Entity
public class ChatBotSettings {
    @NotNull
    @Id
    @Column(name = "providerId")
    private Long providerId;

    @NotNull
    @Setter
    @Column(name = "pm_place")
    private boolean pmPlace;
    @NotNull
    @Setter
    @Column(name = "pm_account")
    private boolean pmAccount;
    @NotNull
    @Setter
    @Column(name = "reservation_update")
    private boolean reservationUpdate;
    @NotNull
    @Setter
    @Column(name = "reservation_cancel")
    private boolean reservationCancel;
    //    @NotNull
//    @Column(name = "wrapping_service")
//    private boolean wrappingService;
    @NotNull
    @Setter
    @Column(name = "reg_date")
    private String reg_date;
    @Column(name = "pm_account_bank")
    @Setter
    private String pmAccountBank;
    @Setter
    @Column(name = "pm_account_input")
    private String pmAccountInput;
    @Setter
    @Column(name = "pm_account_name")
    private String pmAccountName;
    @Setter
    @Column(name = "reservation_option")
    private int reservationOption;
    @Setter
    @Column(name = "reservation_impossible")
    private int reservationImpossible;


}
