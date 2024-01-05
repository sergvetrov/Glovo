package com.example.glovo.converter;

import com.example.glovo.dto.ProductDto;
import com.example.glovo.enity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public static ProductDto toDto(ProductEntity productEntity){
        return ProductDto.builder()
                .name(productEntity.getName())
                .cost(productEntity.getCost())
                .orderId(productEntity.getOrderId())
                .build();
    }

    public static ProductEntity toEntity(ProductDto productDto){
        return ProductEntity.builder()
                .cost(productDto.getCost())
                .name(productDto.getName())
                .orderId(productDto.getOrderId())
                .build();
    }
}
