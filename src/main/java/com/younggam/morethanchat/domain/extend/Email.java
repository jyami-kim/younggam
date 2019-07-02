package com.younggam.morethanchat.domain.extend;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private String subject;
    private String content;
    private String receiver;
}
