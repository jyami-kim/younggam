package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.reservation.ReservationReqDto;
import com.younggam.morethanchat.dto.reservation.ReservationResDto;
import com.younggam.morethanchat.service.ReservationDetailService;
import com.younggam.morethanchat.utils.JwtFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.younggam.morethanchat.utils.ResponseMessage.READ_RESERVATION_DETAIL;
import static com.younggam.morethanchat.utils.ResponseMessage.SAVE_RESERVATION_DETAIL;

@RestController
@Slf4j
@RequestMapping("auth/reservation")
@RequiredArgsConstructor
public class ReservationDetailController {

    private final ReservationDetailService reservationDetailService;
    private final JwtFactory jwtFactory;

    @PostMapping("")
    public ResponseDto saveReservationOption(AuthTokenDto authTokenDto, @RequestBody ReservationReqDto reservationReqDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);

        Long reservationProviderId = reservationDetailService.reservationDetailSave(providerId, reservationReqDto);
        return ResponseDto.of(HttpStatus.OK, SAVE_RESERVATION_DETAIL, reservationProviderId);
    }

    @GetMapping("")
    public ResponseDto getReservationOption(AuthTokenDto authTokenDto) {
        Long providerId = jwtFactory.checkAuth(authTokenDto);

        ReservationResDto reservationDetail = reservationDetailService.getReservationDetail(providerId);
        return ResponseDto.of(HttpStatus.OK, READ_RESERVATION_DETAIL, reservationDetail);
    }

}
