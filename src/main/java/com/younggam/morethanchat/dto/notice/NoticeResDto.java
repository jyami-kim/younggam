package com.younggam.morethanchat.dto.notice;

import com.younggam.morethanchat.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NoticeResDto {
    private Long id;
    private String title;
    private String content;
    private String regDate;

    public NoticeResDto(Notice notice) {
        this.id = notice.getId();
        this.title = notice.getTitle();
        this.content = notice.getContent();
        this.regDate = notice.getRegDate();
    }
}
