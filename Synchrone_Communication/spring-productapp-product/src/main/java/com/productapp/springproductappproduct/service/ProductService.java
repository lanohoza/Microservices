package com.productapp.springproductappproduct.service;

import com.productapp.springproductappproduct.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product>findByCategory(String category);
    Product findById(int id);
}

