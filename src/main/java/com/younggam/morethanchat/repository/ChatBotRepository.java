package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatBotRepository extends JpaRepository<ChatBot, Long> {
    Optional<ChatBot> findByCategoryAndProviderUser(int category, ProviderUser providerUser);
}
