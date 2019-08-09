package com.younggam.morethanchat.utils;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.younggam.morethanchat.utils.ResponseMessage.INVALID_EMAIL_FORMAT;

@Component
@RequiredArgsConstructor
public class CheckElement {

    private final String EMAIL_REGEX = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";

    public void validEmailType(String email) {
        if (!email.matches(EMAIL_REGEX)) {
            throw new NotValidateTypeException(INVALID_EMAIL_FORMAT);
        }
    }

}
