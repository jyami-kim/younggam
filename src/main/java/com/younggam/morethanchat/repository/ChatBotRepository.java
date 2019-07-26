package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatBot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChatBotRepository extends JpaRepository<ChatBot, Long> {
    List<ChatBot> findByProviderIdAndCategoryStartingWith(@NotNull Long providerId, @NotNull String category);
    Optional<ChatBot> findByProviderIdAndCategory(@NotNull Long providerId, @NotNull String category);
}
