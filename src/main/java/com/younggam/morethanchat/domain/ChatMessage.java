package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.utils.DateConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Table(name = "chat_message")
@AllArgsConstructor
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "chatroom_code")
    private String chatRoomCode;

    @NotNull
    private boolean writer;

    @NotNull
    @Column(name = "chat_message")
    private String chatMessage;

    @NotNull
    @Column(name = "written_date")
    private String writtenDate;

    private ChatMessage() {
        this.writtenDate = DateConverter.getNowAllDate();
    }

}
