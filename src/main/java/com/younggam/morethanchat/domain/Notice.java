package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "notice")
@AllArgsConstructor
public class Notice {
    @NotNull
    private Long id;
    private String title;
    private String content;
    @Column(name = "reg_date")
    private String regDate;
}
