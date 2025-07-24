package com.ecommerce.service;

import com.ecommerce.dto.OrderItemDTO;
import com.ecommerce.dto.OrderResponseDTO;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public Order placeOrder(Order order, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());

        //set relationship between order and its items
        for (OrderItem item : order.getItems()) {
            item.setOrder(order);
        }
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> getOrderDTOsByUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return orderRepository.findByUser(user).stream().map(order -> {
            OrderResponseDTO dto = new OrderResponseDTO();
            dto.setId(order.getId());
            dto.setOrderDate(order.getOrderDate());
            dto.setTotalAmount(order.getTotalAmount());
            dto.setDeliveryAddress(order.getDeliveryAddress());
            dto.setContactNumber(order.getContactNumber());
            dto.setPaymentMethod(order.getPaymentMethod());

            List<OrderItemDTO> itemDTOs = order.getItems().stream().map(item -> {
                OrderItemDTO itemDTO = new OrderItemDTO();
                itemDTO.setId(item.getId());
                itemDTO.setProductName(item.getProduct().getName());
                itemDTO.setQuantity(item.getQuantity());
                itemDTO.setPrice(item.getPrice());
                return itemDTO;
            }).toList();

            dto.setItems(itemDTOs);
            return dto;
        }).toList();
    }

}
