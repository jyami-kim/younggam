package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.Notice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
