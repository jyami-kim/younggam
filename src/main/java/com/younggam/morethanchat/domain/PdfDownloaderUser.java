package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter
@Table(name = "pdf_downloader_user")
@AllArgsConstructor
public class PdfDownloaderUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String phoneNum;

    @NotNull
    private String email;

    @NotNull
    private String job;

    @NotNull
    private String knowPath;
}
