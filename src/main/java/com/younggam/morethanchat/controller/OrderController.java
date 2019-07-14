package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.order.OrderManageResultReqDto;
import com.younggam.morethanchat.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.younggam.morethanchat.utils.DateConverter.getNowDate;
import static com.younggam.morethanchat.utils.ResponseMessage.*;

@RestController
@Slf4j
@RequestMapping("/auth/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("main")
    public ResponseDto getMainOrderList(@RequestAttribute Long providerId, @RequestParam(required = false) String searchDate) {
        if (searchDate == null)
            searchDate = getNowDate();
        OrderManageResultReqDto mainOrderResult = orderService.getMainOrderList(providerId, searchDate);
        return ResponseDto.of(HttpStatus.OK, messageCode(GET_ORDER_LIST_SUCCESS, searchDate), mainOrderResult);
    }

    @PutMapping("status/{orderId}")
    public ResponseDto setOrderStatusChange(@RequestAttribute Long providerId, @PathVariable Long orderId) {
        orderId = orderService.updateOrderStatus(orderId, providerId);
        return ResponseDto.of(HttpStatus.OK, UPDATE_ORDER_STATUS_SUCCESS, orderId);
    }

//    @PostMapping("{orderId}")
//    public ResponseDto setOrderComplete(@RequestAttribute Long proividerId,@PathVariable Long orderId){
//
//    }

}
