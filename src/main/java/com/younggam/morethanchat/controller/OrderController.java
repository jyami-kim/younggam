package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.dto.order.OrderManageResDto;
import com.younggam.morethanchat.service.OrderService;
import javafx.util.converter.TimeStringConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.younggam.morethanchat.utils.DateConverter.getNowDate;
import static com.younggam.morethanchat.utils.ResponseMessage.GET_ORDER_LIST_SUCCESS;
import static com.younggam.morethanchat.utils.ResponseMessage.messageCode;

@RestController
@Slf4j
@RequestMapping("/auth/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("main")
    public ResponseDto getMainOrderList(@RequestAttribute Long providerId, @RequestParam(required = false) String searchDate) {
        if(searchDate == null)
            searchDate = getNowDate();
        List<OrderManageResDto> mainOrderList = orderService.getMainOrderList(providerId, searchDate);
        return ResponseDto.of(HttpStatus.OK, messageCode(GET_ORDER_LIST_SUCCESS, searchDate), mainOrderList);
    }

}
