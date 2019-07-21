package com.younggam.morethanchat.repository;

import com.younggam.morethanchat.domain.TodayProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface TodayProductRepository extends JpaRepository<TodayProduct, Long> {
    List<TodayProduct> findAllByRegDateAndProviderId(@NotNull String regDate, @NotNull Long providerId);
}
