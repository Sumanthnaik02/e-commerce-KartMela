package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // ✅ Save a new product
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    // ✅ Get all products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // You can add more: getById(), deleteById(), updateProduct(), etc.
}
