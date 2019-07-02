package com.younggam.morethanchat.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ProductsByDateResDto {
    private String name;
    private String description;
    private int price;
    private int stock;
    private String image;
    private int isFixed;
}
