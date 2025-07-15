package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    //get all products
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    //get newest products
    public List<Product> getNewestProducts(){
        return productRepo.findByIsNewTrue();
    }

    //get products by id
    public Product getProductById(Long id){
        return productRepo.findById(id).orElse(null);
    }

    //save products
    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    //delete products by id
    public void deleteProductById(Long id){
         productRepo.deleteById(id);
    }
}
