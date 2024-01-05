package com.example.glovo.converter;

import com.example.glovo.dto.OrderDto;
import com.example.glovo.enity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public static OrderDto toDto(OrderEntity orderEntity){
        return OrderDto.builder()
                .products(orderEntity.getProducts().stream().map(ProductConverter::toDto).toList())
                .customerName(orderEntity.getCustomerName())
                .build();
    }

    public static OrderEntity toEntity(OrderDto orderDto){
        return OrderEntity.builder()
                .customerName(orderDto.getCustomerName())
                .products(orderDto.getProducts().stream().map(ProductConverter::toEntity).toList())
                .build();
    }
}
