package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.order.OrderManageResDto;
import com.younggam.morethanchat.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.younggam.morethanchat.utils.DateConverter.getNowDate;
import static com.younggam.morethanchat.utils.ResponseMessage.UPDATE_USER;
import static com.younggam.morethanchat.utils.ResponseMessage.messageCode;

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
        List<OrderManageResDto> mainOrderList = orderService.getMainOrderList(providerId, searchDate);
        return ResponseDto.of(HttpStatus.OK, messageCode(UPDATE_USER, searchDate), mainOrderList);
    }

//    @PostMapping("{orderId}")
//    public ResponseDto setOrderComplete(@RequestAttribute Long proividerId,@PathVariable Long orderId){
//
//    }

}
