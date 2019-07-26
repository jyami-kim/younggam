package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatBot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatBotRepository extends JpaRepository<ChatBot, Long> {
}
