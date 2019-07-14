package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.OrderManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderManagementRepository extends JpaRepository<OrderManagement, Long> {
}
