package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.Inquiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface InquiriesRepository extends JpaRepository<Inquiries, Long> {
    Optional<Inquiries> findByCustomerIdAndProviderId(@NotNull Long customerId, @NotNull Long providerId);
}
