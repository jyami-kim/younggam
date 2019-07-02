package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.domain.ProviderUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="provider_id")
    private ProviderUser providerId;

    private String name;

    private String description;

    private int price;

    private int stock;

    private String image;

    @Column(name="is_fixed")
    private int isFixed;

    @Column(name="reg_date")
    private String regDate;

    @Column(name="recent_reg_date")
    private String recentRegDate;

}
