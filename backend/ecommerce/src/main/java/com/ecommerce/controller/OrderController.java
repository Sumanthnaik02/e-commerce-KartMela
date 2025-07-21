package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //place an order(checkout)
    @PostMapping("checkout")
    public ResponseEntity<?> placeOrder(@RequestBody Order order){
        if(order.getUser() == null || order.getUser().getEmail() == null){
            return ResponseEntity.badRequest().body("Missing user email");
        }
        Order savedOrder = orderService.placeOrder(order,order.getUser().getEmail());
        return ResponseEntity.ok(savedOrder);
    }

    //get all orders for a user ny email
    @GetMapping ResponseEntity<?> getOrderByEmail(@RequestParam("email") String email){
        List<Order> orders =orderService.getOrderByUser(email);
        return ResponseEntity.ok(orders);
    }
}
