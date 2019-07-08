package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderUserRepository extends JpaRepository<ProviderUser, Long> {
    Optional<ProviderUser> findByPhoneNumAndName(String phoneNum, String name);

    Optional<ProviderUser> findByPhoneNumAndEmail (String phoneNum, String email);
}
