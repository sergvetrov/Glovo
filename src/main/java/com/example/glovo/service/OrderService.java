package com.example.glovo.service;


import com.example.glovo.dto.OrderDto;
import com.example.glovo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public OrderDto getById(int id) {
        return orderRepository.findById(id);
    }

    public OrderDto save(OrderDto orderDto) {
        return orderRepository.save(orderDto);
    }

    public OrderDto update(int id, OrderDto orderDto) {
        return orderRepository.update(id, orderDto);
    }

    public OrderDto updateProducts(int id, String product) {
        return orderRepository.updateProducts(id, product);
    }

    public OrderDto deleteProduct(int id, String product) {
        return orderRepository.deleteProduct(id, product);
    }

    public OrderDto delete(int id) {
        return orderRepository.delete(id);
    }
}
