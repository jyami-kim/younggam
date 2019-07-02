package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "product")
@AllArgsConstructor
public class Product {
    private Long id;

    @Column(name = "provider_id")
    @NotNull
    private Long provider_id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private int price;
    private int stock;
    @NotNull
    private String image;
    @NotNull
    @Column(name = "is_fixed")
    private boolean is_fixed;
}
