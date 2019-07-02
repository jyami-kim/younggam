package com.younggam.morethanchat.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "today_product")
public class TodayProduct {
    @NotNull
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    @NotNull
    @Column(name = "reg_date")
    private String regDate;
}
