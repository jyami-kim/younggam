package com.younggam.morethanchat.dto.product;

import com.younggam.morethanchat.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductResDto {

    private String name;
    private String description;
    private int price;
    private String image;

    public ProductResDto(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.image = product.getImage();
    }

}
