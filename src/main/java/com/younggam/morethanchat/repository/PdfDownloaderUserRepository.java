package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.PdfDownloaderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdfDownloaderUserRepository extends JpaRepository<PdfDownloaderUser, Long> {
}
