package com.example.glovo.repository;

import com.example.glovo.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {

    private List<OrderDto> orders = List.of(
            OrderDto.builder().products(List.of("Bananas", "Bottle of water")).customerId(12).build(),
            OrderDto.builder().products(List.of("Nuts", "Milk", "Bread")).customerId(25).build());

    public OrderDto findById(int id) {
        return orders.get(id);
    }

    public boolean save(OrderDto orderDto) {
        ArrayList<OrderDto> newOrders = new ArrayList<>(orders);
        boolean isSave = newOrders.add(orderDto);
        orders = newOrders;
        return isSave;
    }

    public OrderDto update(int id, OrderDto orderDto) {
        ArrayList<OrderDto> newOrders = new ArrayList<>(orders);
        newOrders.set(id, orderDto);
        orders = newOrders;
        return orderDto;
    }

    public OrderDto updateProducts(int id, String product) {
        OrderDto currentOrder = orders.get(id);
        List<String> currentProducts = currentOrder.getProducts();
        List<String> newProducts = new ArrayList<>(currentProducts);
        newProducts.add(product);
        currentOrder.setProducts(newProducts);
        List<OrderDto> newOrders = new ArrayList<>(orders);
        newOrders.set(id, currentOrder);
        orders = newOrders;
        return currentOrder;
    }

    public OrderDto deleteProduct(int id, String product) {
        OrderDto currentOrder = orders.get(id);
        List<String> currentProducts = currentOrder.getProducts();
        List<String> newProducts = new ArrayList<>(currentProducts);
        newProducts.remove(product);
        currentOrder.setProducts(newProducts);
        List<OrderDto> newOrders = new ArrayList<>(orders);
        newOrders.set(id, currentOrder);
        orders = newOrders;
        return currentOrder;
    }

    public boolean delete(int id) {
        ArrayList<OrderDto> newOrders = new ArrayList<>(orders);
        boolean isDelete = newOrders.remove(orders.get(id));
        orders = newOrders;
        return isDelete;
    }
}
