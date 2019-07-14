package com.younggam.morethanchat.service;

import com.younggam.morethanchat.domain.OrderManagement;
import com.younggam.morethanchat.dto.order.OrderManageResDto;
import com.younggam.morethanchat.dto.order.OrderManageResultReqDto;
import com.younggam.morethanchat.dto.order.OrderManagementMapperDto;
import com.younggam.morethanchat.exception.NotFoundException;
import com.younggam.morethanchat.mapper.OrderMapper;
import com.younggam.morethanchat.repository.OrderManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public OrderManageResultReqDto getMainOrderList(Long providerId, String searchDate) {
        List<OrderManageResDto> mainPage = orderMapper.getMainPage(providerId, searchDate);

        int profit = mainPage.stream()
                .mapToInt(OrderManageResDto::getTotalPayment)
                .sum();

        return OrderManageResultReqDto.builder()
                .amountAsk(mainPage.size())
                .amountOrder(mainPage.size())
                .expectProfit(profit)
                .orderManageResultReqDtos(mainPage)
                .build();
    }
}
