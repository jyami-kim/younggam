package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.*;

import javax.persistence.*;

import static com.younggam.morethanchat.utils.ResponseMessage.CHATBOT_CATEGORY_IS_NOT_VALID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "chatbot")
@Builder
@AllArgsConstructor
public class ChatBot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private ProviderUser providerUser;

    private int category;

    @Setter
    private String message;

    public void validateCategory(){
        if (!(category == 1 || category == 2 || category == 3)) {
            throw new NotValidateTypeException(CHATBOT_CATEGORY_IS_NOT_VALID);
        }
    }
}
