package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "today_product")
public class TodayProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_id")
    private Long productId;

    @NotNull
    @Column(name = "reg_date")
    private String regDate;

    @NotNull
    @Column(name = "providerId")
    private Long providerId;
}
