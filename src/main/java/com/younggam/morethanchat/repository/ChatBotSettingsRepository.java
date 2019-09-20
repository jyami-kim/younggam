package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatBotSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBotSettingsRepository extends JpaRepository<ChatBotSettings, Long> {
    ChatBotSettings findByProviderId(Long providerId);
}
