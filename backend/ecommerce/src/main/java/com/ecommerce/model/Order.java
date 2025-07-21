package com.ecommerce.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Long id ;

    private LocalDateTime orderDate;

    private Double totalAmount;

    private String deliveryAddress;
    private String contactNumber;
    private String paymentMethod;

    @ManyToOne//one user can have multiple orders
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy= "order",cascade = CascadeType.ALL)//one order can have multiple order items
    private List<OrderItem> items;

    public Order() {
    }

    public Order(Long id, LocalDateTime orderDate, Double totalAmount, String deliveryAddress, String contactNumber, String paymentMethod, User user, List<OrderItem> items) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.deliveryAddress = deliveryAddress;
        this.contactNumber = contactNumber;
        this.paymentMethod = paymentMethod;
        this.user = user;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
