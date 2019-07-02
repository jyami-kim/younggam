package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ChatBot;
import com.younggam.morethanchat.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
    findAllBy
}
