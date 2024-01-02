package com.example.glovo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class OrderDto {
    private int id;
    private List<String> products;
    private int customerId;
}
