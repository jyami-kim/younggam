package com.younggam.morethanchat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@Table(name = "product")
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider_id")
    @NotNull
    private Long providerId;

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
