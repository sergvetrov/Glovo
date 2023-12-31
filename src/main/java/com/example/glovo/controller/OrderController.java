package com.example.glovo.controller;

import com.example.glovo.dto.OrderDto;
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
    public boolean save(@RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @PutMapping("/{id}")
    public OrderDto update(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return orderService.update(id, orderDto);
    }

    @PatchMapping("/{id}/products")
    public OrderDto updateProducts(@PathVariable int id, @RequestBody String product) {
        return orderService.updateProducts(id, product);
    }

    @DeleteMapping("/{id}/products")
    public OrderDto deleteProduct(@PathVariable int id, @RequestBody String product) {
        return orderService.deleteProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return orderService.delete(id);
    }
}
