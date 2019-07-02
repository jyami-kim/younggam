package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "chat_message")
@AllArgsConstructor
public class ChatMessage {
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

}
