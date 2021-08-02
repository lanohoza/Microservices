package com.productapp.springproductappproduct.controllers;

import com.productapp.springproductappproduct.models.Product;
import com.productapp.springproductappproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-service")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")

    public List<Product> findAll(){
    return productService.findAll();
}
    @GetMapping("/products-by-category/{category}")
    public List<Product>findByCategory(@PathVariable("category") String category){
    return productService.findByCategory(category);
    }

    @GetMapping("/product-by-id/{productId}")
    public Product findById(@PathVariable("productId") int id){
    return productService.findById(id);
    }
}
