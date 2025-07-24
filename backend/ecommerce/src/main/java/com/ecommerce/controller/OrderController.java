package com.ecommerce.controller;

import com.ecommerce.dto.OrderRequestDTO;
import com.ecommerce.dto.OrderResponseDTO;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //place an order(checkout)
    @PostMapping("/checkout")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequestDTO request){
        if(request.getEmail() == null || request.getEmail().isEmpty()){
            return ResponseEntity.badRequest().body("Missing user email");
        }
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setItems((request.getItems()));
        order.setDeliveryAddress(request.getDeliveryAddress());
        order.setContactNumber(request.getContactNumber());
        order.setPaymentMethod(request.getPaymentMethod());

        for(OrderItem item:request.getItems()){
            item.setOrder(order);
        }

        Order savedOrder = orderService.placeOrder(order, request.getEmail());
        return ResponseEntity.ok(savedOrder);
    }

    //get all orders for a user by email
    @GetMapping
    public ResponseEntity<?> getOrderByEmail(@RequestParam("email") String email){
        List<OrderResponseDTO> orders = orderService.getOrderDTOsByUser(email);
        return ResponseEntity.ok(orders);
    }
}
