package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.utils.TypeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
    private String chat_message;

    @NotNull
    @Column(name = "written_date")
    private String writtenDate;

    private ChatMessage() {
        this.writtenDate = TypeConverter.getNowAllDate();
    }

    public boolean getWriter(){
        return this.writer;
    }
}
