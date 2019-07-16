package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.Inquiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiriesRepository extends JpaRepository<Inquiries, Long> {
}
