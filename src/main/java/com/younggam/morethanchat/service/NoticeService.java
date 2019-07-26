package com.younggam.morethanchat.service;

import com.younggam.morethanchat.dto.additional.NoticeResDto;
import com.younggam.morethanchat.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeResDto> getNotices() {
        return noticeRepository.findAllByOrderByIdDesc()
                .stream()
                .map(NoticeResDto::new)
                .collect(Collectors.toList());
    }

}
