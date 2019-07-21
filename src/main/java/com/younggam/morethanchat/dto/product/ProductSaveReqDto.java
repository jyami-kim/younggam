package com.younggam.morethanchat.dto.product;

import com.younggam.morethanchat.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Getter
public class ProductSaveReqDto {

    public static String DEFAULT_IMAGE = "default_product.jpg";

    private String name;
    private String description;
    private int price;
    @Setter
    private MultipartFile imageFile;
    @Setter
    private String image;


    public Product toEntity(Long providerId) {
        return Product.builder()
                .provider_id(providerId)
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .image(this.image)
                .is_fixed(false)
                .stock(0)
                .build();
    }
}
