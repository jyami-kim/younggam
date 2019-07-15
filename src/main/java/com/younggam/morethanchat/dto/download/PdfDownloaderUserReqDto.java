package com.younggam.morethanchat.dto.download;

import com.younggam.morethanchat.domain.PdfDownloaderUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class PdfDownloaderUserReqDto {
    private String name;
    private String phoneNum;
    private String email;
    private String job;
    private String knowPath;

    public PdfDownloaderUser toEntity(){
        return PdfDownloaderUser.builder()
                .email(this.email)
                .phoneNum(this.phoneNum)
                .name(this.name)
                .job(this.job)
                .knowPath(this.knowPath)
                .build();
    }
}
