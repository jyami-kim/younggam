package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.utils.TypeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Table(name = "inquiries_reply")
@AllArgsConstructor
public class InquiriesReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "inquiries_id")
    private String InquiriesId;

    @Column(name = "reply")
    private String reply;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    private InquiriesReply() {
        this.regDate = TypeConverter.getNowAllDate();
    }
}
