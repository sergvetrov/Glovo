package com.example.glovo.repository;

import com.example.glovo.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderRepository {
    private final Map<Integer, OrderDto> orders = new HashMap<>();
    private Integer orderId = 0;

    public OrderDto findById(int id) {
        return orders.get(id);
    }

    public OrderDto save(OrderDto orderDto) {
        return orders.put(orderId++, orderDto);
    }

    public OrderDto update(int id, OrderDto orderDto) {
        return orders.replace(id, orderDto);
    }

    public OrderDto updateProducts(int id, String product) {
        OrderDto currentOrder = orders.get(id);
        List<String> currentProducts = currentOrder.getProducts();
        currentProducts.add(product);
        currentOrder.setProducts(currentProducts);
        return orders.replace(id, currentOrder);
    }

    public OrderDto deleteProduct(int id, String product) {
        OrderDto currentOrder = orders.get(id);
        List<String> currentProducts = currentOrder.getProducts();
        currentProducts.remove(product);
        currentOrder.setProducts(currentProducts);
        return orders.replace(id, currentOrder);
    }

    public OrderDto delete(int id) {
        return orders.remove(id);
    }
}
