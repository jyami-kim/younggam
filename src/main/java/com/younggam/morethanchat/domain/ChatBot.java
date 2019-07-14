package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.younggam.morethanchat.utils.ResponseMessage.CHATBOT_CATEGORY_IS_NOT_VALID;

@Getter
@NoArgsConstructor
@Table(name = "chatbot")
@AllArgsConstructor
@Builder
@Entity
public class ChatBot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "provider_id")
    private Long provider_id;
    @NotNull
    private String category;
    @Setter
    @NotNull
    private String message;
}
