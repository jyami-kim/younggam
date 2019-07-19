package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    Optional<ChatRoom> findByChatRoomCodeAndCustomerIdAndProviderId(@NotNull String chatRoomCode, @NotNull Long customerId, @NotNull Long providerId);
}
