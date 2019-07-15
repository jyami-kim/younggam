package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.OrderManagement;
import com.younggam.morethanchat.dto.order.OrderManageResDto;
import com.younggam.morethanchat.dto.order.OrderManageResultResDto;
import com.younggam.morethanchat.dto.order.OrderManageShortResDto;
import com.younggam.morethanchat.dto.order.OrderManagementMapperDto;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.mapper.OrderMapper;
import com.younggam.morethanchat.repository.OrderManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.younggam.morethanchat.utils.DateConverter.getNowDate;
import static com.younggam.morethanchat.utils.ResponseMessage.NOT_FOUND_ORDER;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderManagementRepository orderManagementRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public Long updateOrderStatus(Long orderId, Long providerId) {

        OrderManagementMapperDto orderManagement = orderMapper.findByOrderIdWithProviderCheck(providerId, orderId)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ORDER));

        orderManagement.setOrderStatus(!orderManagement.isOrderStatus());

        OrderManagement save = orderManagementRepository.save(orderManagement.toEntity());
        return save.getOrderId();
    }

    public OrderManageResultResDto getMainOrderList(Long providerId, String searchDate) {
        int profit = 0;
        int askAmount = 0;

        List<OrderManageResDto> mainPage = orderMapper.getMainPage(providerId, searchDate);

        long[] inquiresCustomerId = new long[mainPage.size()];
        for (int i = 0; i < inquiresCustomerId.length; i++) {
            inquiresCustomerId[i] = mainPage.get(i).getCustomerId();
        }

        List<Long> inquires = new ArrayList<>();
        if (inquiresCustomerId[0] != 0) {
            inquires = orderMapper.getInquires(providerId, inquiresCustomerId);
        }

        List<OrderManageResDto> list = new ArrayList<>();
        for (OrderManageResDto x : mainPage) {
            if (inquires.contains(x.getCustomerId())) {
                x.setInquiries(true);
                askAmount++;
            }
            list.add(x);
            profit += x.getTotalPayment();
        }

        mainPage = list;

        return OrderManageResultResDto.builder()
                .amountAsk(askAmount)
                .amountOrder(mainPage.size())
                .expectProfit(profit)
                .orderManageResDtos(mainPage)
                .build();
    }

    public OrderManageResultResDto getTodayOrderShort(Long providerId, String searchDate) {
        List<OrderManageShortResDto> orderShort = orderMapper.getOrderShort(providerId, searchDate);

        int askAmount = 0;

        long[] inquiresCustomerId = new long[orderShort.size()];
        for (int i = 0; i < inquiresCustomerId.length; i++) {
            inquiresCustomerId[i] = orderShort.get(i).getCustomerId();
        }

        List<Long> inquires = new ArrayList<>();
        if (inquiresCustomerId.length != 0 && inquiresCustomerId[0] != 0) {
            inquires = orderMapper.getInquires(providerId, inquiresCustomerId);
        }

        for (OrderManageShortResDto x : orderShort) {
            if (inquires.contains(x.getCustomerId())) {
                askAmount++;
            }
        }

        return OrderManageResultResDto.builder()
                .amountAsk(askAmount)
                .amountOrder(orderShort.size())
                .build();
    }
}
