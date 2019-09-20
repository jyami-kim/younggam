package com.younggam.morethanchat.dto.reservation;

import com.younggam.morethanchat.domain.ChatBotSettings;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationResDto {

    private String coolPackingMessage;

    private boolean pmPlace;
    private boolean pmAccount;
    private boolean reservationUpdate;
    private boolean reservationCancel;

    private String pmAccountBank;
    private String pmAccountInput;
    private String pmAccountName;
    private int reservationOption;
    private int reservationImpossible;

    public ReservationResDto(ChatBotSettings chatBotSettings, String coolPackingMessage) {
        this.coolPackingMessage = coolPackingMessage;
        this.pmPlace = chatBotSettings.isPmPlace();
        this.pmAccount = chatBotSettings.isPmAccount();
        this.reservationUpdate = chatBotSettings.isReservationUpdate();
        this.reservationCancel = chatBotSettings.isReservationCancel();

        this.pmAccountBank = chatBotSettings.getPmAccountBank();
        this.pmAccountInput = chatBotSettings.getPmAccountInput();
        this.pmAccountName = chatBotSettings.getPmAccountName();
        this.reservationOption = chatBotSettings.getReservationOption();
        this.reservationImpossible = chatBotSettings.getReservationImpossible();
    }
}
