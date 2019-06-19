package com.younggam.morethanchat;

import com.younggam.morethanchat.domain.ProviderUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="chatbot")
public class ChatBot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: providerUSer 바인딩
    private ProviderUser providerUser;

    private String category;

    private String message;

}
