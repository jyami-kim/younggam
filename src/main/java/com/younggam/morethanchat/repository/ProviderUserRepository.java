package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.ProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ProviderUserRepository extends JpaRepository<ProviderUser, Long> {
    Optional<ProviderUser> findByEmail(String email);
}
