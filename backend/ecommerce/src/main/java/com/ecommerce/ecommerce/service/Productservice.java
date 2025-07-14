package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Productservice {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAllPoducts(){
        return repo.findAll();
    }
}
