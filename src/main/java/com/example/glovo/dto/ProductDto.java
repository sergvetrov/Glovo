package com.example.glovo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ProductDto {
    private String name;
    private float cost;
    private int orderId;
}
