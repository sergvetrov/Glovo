package com.example.glovo.service;


import com.example.glovo.converter.OrderConverter;
import com.example.glovo.converter.ProductConverter;
import com.example.glovo.dto.OrderDto;
import com.example.glovo.dto.ProductDto;
import com.example.glovo.enity.OrderEntity;
import com.example.glovo.enity.ProductEntity;
import com.example.glovo.repository.OrderRepository;
import com.example.glovo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderDto getById(int id) {
        return orderRepository.findById(id).map(OrderConverter::toDto).orElseThrow();
    }

    public OrderDto save(OrderDto orderDto) {

        OrderEntity savedOrder = orderRepository.save(OrderConverter.toEntity(orderDto));
        int id = savedOrder.getId();
        savedOrder.getProducts().forEach(p -> p.setOrderId(id));
        productRepository.saveAll(savedOrder.getProducts());
        return OrderConverter.toDto(savedOrder);
    }

    public OrderDto update(int id, OrderDto orderDto) {
        OrderDto neededOrder = orderRepository.findById(id).map(OrderConverter::toDto).orElseThrow();
        neededOrder.setProducts(orderDto.getProducts());
        neededOrder.setCustomerName(orderDto.getCustomerName());
        return this.save(neededOrder);
    }

    public OrderDto addProduct(int id, ProductDto productDto) {
        ProductEntity savedProduct = productRepository.save(ProductConverter.toEntity(productDto));
        OrderEntity neededOrder = orderRepository.findById(id).orElseThrow();
        neededOrder.getProducts().add(savedProduct);
        return this.update(neededOrder.getId(), OrderConverter.toDto(neededOrder));
    }

    public OrderDto deleteProduct(int id, int productId) {
        OrderEntity neededOrder = orderRepository.findById(id).orElseThrow();
        neededOrder.getProducts().remove(productId);
        return this.update(neededOrder.getId(), OrderConverter.toDto(neededOrder));
    }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }
}
