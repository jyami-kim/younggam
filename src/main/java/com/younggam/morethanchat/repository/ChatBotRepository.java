package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatBotRepository extends JpaRepository<ChatBot, Long> {
}
