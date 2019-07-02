package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderUserRepository extends JpaRepository<ProviderUser, Long> {
}
