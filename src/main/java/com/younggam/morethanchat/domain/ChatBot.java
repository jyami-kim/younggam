package com.younggam.morethanchat.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
