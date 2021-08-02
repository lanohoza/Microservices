package com.productapp.springproductappproduct.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    Integer productId;
    String name;
    String marque;
    String category;
    double price;
}
