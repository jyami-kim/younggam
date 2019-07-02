package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import static com.younggam.morethanchat.utils.ResponseMessage.CHATBOT_CATEGORY_IS_NOT_VALID;

@Getter
@NoArgsConstructor
@Table(name = "chatbot")
@AllArgsConstructor
@Builder
@Entity
public class ChatBot {
    @NotNull
    @Id
    private Long id;
    @NotNull
    @Column(name = "provider_id")
    private Long provider_id;
    @NotNull
    private String category;
    @Setter
    @NotNull
    private String message;

    public void validateCategory() {
        // TODO : ENUM 만들어서 validate 처리하기
        if (category.isEmpty()) {
            throw new NotValidateTypeException(CHATBOT_CATEGORY_IS_NOT_VALID);
        }
    }
}
