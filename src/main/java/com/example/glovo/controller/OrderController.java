package com.example.glovo.controller;

import com.example.glovo.dto.OrderDto;
import com.example.glovo.dto.ProductDto;
import com.example.glovo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @PostMapping()
    public OrderDto save(@RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @PutMapping("/{id}")
    public OrderDto update(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return orderService.update(id, orderDto);
    }

    @PatchMapping("/{id}/products")
    public OrderDto updateProducts(@PathVariable int id, @RequestBody ProductDto productDto) {
        return orderService.addProduct(id, productDto);
    }

    @DeleteMapping("/{id}/products/{productId}")
    public OrderDto deleteProduct(@PathVariable int id, @PathVariable int productId) {
        return orderService.deleteProduct(id, productId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }
}
