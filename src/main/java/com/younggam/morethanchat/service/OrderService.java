package com.younggam.morethanchat.service;

import com.younggam.morethanchat.dto.order.OrderManageResDto;
import com.younggam.morethanchat.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public List<OrderManageResDto> getMainOrderList(Long providerId, String searchDate){
        return orderMapper.getMainPage(providerId, searchDate);
    }
}
