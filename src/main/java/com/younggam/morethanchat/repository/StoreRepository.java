package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByProviderId(Long providerId);

    Optional<Store> findByName(String name);

    Optional<Store> findByBotId(String botId);
}
