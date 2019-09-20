package com.younggam.morethanchat.dto.reservation;

import com.younggam.morethanchat.domain.ChatBotSettings;
import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.younggam.morethanchat.utils.TypeConverter.getNowAllDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservationReqDto {

    private String coolPackingMessage;

    private boolean pmPlace;
    private boolean pmAccount;
    private boolean reservationUpdate;
    private boolean reservationCancel;

    private String pmAccountBank;
    private String pmAccountInput;
    private String pmAccountName;
    private int reservationOption;
    private Integer reservationImpossible;

    private void pmAccountValidate() {
        if (pmAccount && (pmAccountBank == null || pmAccountInput == null || pmAccountName == null)) {
            throw new NotValidateTypeException("pm Account와 관련된 값들이 부족합니다.");
        }
    }

    private void reservationOptionValidate() {
        if (reservationOption == 3 && reservationImpossible == null) {
            throw new NotValidateTypeException("reservation Option 과 관련된 값이 부족합니다.");
        }
    }

    public ChatBotSettings toChatBotSettingsEntity(Long providerId) {

        pmAccountValidate();
        reservationOptionValidate();
        ReservationDetail.validateReasonNumber(this.reservationOption);

        return ChatBotSettings.builder()
                .providerId(providerId)
                .pmAccount(this.pmAccount)
                .pmPlace(this.pmPlace)
                .pmAccountBank(this.pmAccountBank)
                .pmAccountInput(this.pmAccountInput)
                .pmAccountName(this.pmAccountName)
                .reservationCancel(this.reservationCancel)
                .reservationUpdate(this.reservationUpdate)
                .reservationOption(this.reservationOption)
                .reservationImpossible(this.reservationImpossible)
                .reg_date(getNowAllDate())
                .build();
    }

    public ChatBotSettings toChatBotSettingsEdit(ChatBotSettings chatBotSettings) {

        pmAccountValidate();
        reservationOptionValidate();
        ReservationDetail.validateReasonNumber(this.reservationOption);

        chatBotSettings.setPmAccount(this.pmAccount);
        chatBotSettings.setPmPlace(this.pmPlace);
        chatBotSettings.setPmAccountBank(this.pmAccountBank);
        chatBotSettings.setPmAccountInput(this.pmAccountInput);
        chatBotSettings.setPmAccountName(this.pmAccountName);
        chatBotSettings.setReservationCancel(this.reservationCancel);
        chatBotSettings.setReservationUpdate(this.reservationUpdate);
        chatBotSettings.setReservationOption(this.reservationOption);
        chatBotSettings.setReservationImpossible(this.reservationImpossible);
        chatBotSettings.setReg_date(getNowAllDate());

        return chatBotSettings;
    }
}
