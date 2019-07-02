package com.younggam.morethanchat.controller;

import com.younggam.morethanchat.dto.ResponseDto;
import com.younggam.morethanchat.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/auth/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("main")
    public ResponseDto getMainOrderList(@RequestAttribute Long providerId, @RequestParam(required = false) String searchDate) {
        orderService.getMainOrderList(providerId, searchDate);
    }


}
