package com.example.glovo.dto;

import com.example.glovo.enity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class OrderDto {
    private List<ProductDto> products;
    private String customerName;
}
