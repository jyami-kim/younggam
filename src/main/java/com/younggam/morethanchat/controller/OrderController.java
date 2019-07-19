package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.AuthTokenDto;
import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.order.OrderManageResultResDto;
import com.younggam.morethanchat.exception.TokenException;
import com.younggam.morethanchat.service.OrderService;
import com.younggam.morethanchat.utils.JwtFactory;
import com.younggam.morethanchat.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.younggam.morethanchat.utils.ResponseMessage.*;
import static com.younggam.morethanchat.utils.TypeConverter.getNowDate;

@RestController
@Slf4j
@RequestMapping("auth/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final JwtFactory jwtFactory;

    @GetMapping("main")
    public ResponseDto<OrderManageResultResDto> getMainOrderList(AuthTokenDto authTokenDto, @RequestParam(required = false) String searchDate) {
        Long providerId = checkAuth(authTokenDto);
        if (searchDate == null)
            searchDate = getNowDate();
        OrderManageResultResDto mainOrderResult = orderService.getMainOrderList(providerId, searchDate);
        return ResponseDto.of(HttpStatus.OK, messageCode(GET_ORDER_LIST_SUCCESS, searchDate), mainOrderResult);
    }

    @GetMapping("main/short")
    public ResponseEntity<ResponseDto<OrderManageResultResDto>> getOrderShortest(AuthTokenDto authTokenDto, @RequestParam(required = false) String searchDate) {
        Long providerId = checkAuth(authTokenDto);
        if (searchDate == null)
            searchDate = getNowDate();
        OrderManageResultResDto mainOrderResult = orderService.getTodayOrderShort(providerId, searchDate);
        return new ResponseEntity<>(ResponseDto.of(HttpStatus.OK, messageCode(GET_TODAY_ORDER_SUCCESS, getNowDate()), mainOrderResult), HttpStatus.OK);
    }

    @PutMapping("status/{orderId}")
    public ResponseDto<Long> setOrderStatusChange(AuthTokenDto authTokenDto, @PathVariable Long orderId) {
        Long providerId = checkAuth(authTokenDto);
        orderId = orderService.updateOrderStatus(orderId, providerId);
        return ResponseDto.of(HttpStatus.OK, UPDATE_ORDER_STATUS_SUCCESS, orderId);
    }

    private Long checkAuth(AuthTokenDto authTokenDto){
        return jwtFactory.getUserId(authTokenDto.getToken())
                .orElseThrow(() -> new TokenException(ResponseMessage.AUTH));
    }

}
