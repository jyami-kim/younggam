package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.PaymentManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentManagementRepository extends JpaRepository<PaymentManagement, Long> {
}
