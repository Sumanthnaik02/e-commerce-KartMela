package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/newest")
    public List<Product> getNewest(){
        return productService.getNewestProducts();
    }

    @GetMapping("/{id}")
    public Product getBuId(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product add(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}
