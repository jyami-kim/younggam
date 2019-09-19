package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.RestDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestDateRepository extends JpaRepository<RestDate, Long> {
    List<RestDate> findByProviderId(Long providerId);


}
