package com.example.glovo.repository;

import com.example.glovo.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderRepository {
    private final Map<String, OrderDto> orders = new HashMap<>();
    private int orderId = 0;

    public OrderDto findById(int id) {
        if(orders.containsKey(String.valueOf(id))){
            return orders.get(String.valueOf(id));
        }
        return OrderDto.builder().build();
    }

    public OrderDto save(OrderDto orderDto) {
        orderDto.setId(orderId++);
        return orders.put(String.valueOf(orderDto.getId()), orderDto);
    }

    public OrderDto update(int id, OrderDto orderDto) {
        if(orders.containsKey(String.valueOf(id))){
            return orders.replace(String.valueOf(id), orderDto);
        }
        return OrderDto.builder().build();
    }

    public OrderDto updateProducts(int id, String product) {
        if(orders.containsKey(String.valueOf(id))){
            OrderDto currentOrder = orders.get(String.valueOf(id));
            List<String> currentProducts = currentOrder.getProducts();
            currentProducts.add(product);
            currentOrder.setProducts(currentProducts);
            return orders.replace(String.valueOf(id), currentOrder);
        }
        return OrderDto.builder().build();
    }

    public OrderDto deleteProduct(int id, String product) {
        if(orders.containsKey(String.valueOf(id))) {
            OrderDto currentOrder = orders.get(String.valueOf(id));
            List<String> currentProducts = currentOrder.getProducts();
            currentProducts.remove(product);
            currentOrder.setProducts(currentProducts);
            return orders.replace(String.valueOf(id), currentOrder);
        }
        return OrderDto.builder().build();
    }

    public OrderDto delete(int id) {
        if(orders.containsKey(String.valueOf(id))) {
            return orders.remove(String.valueOf(id));
        }
        return OrderDto.builder().build();
    }
}
