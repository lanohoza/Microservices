package com.orderapp.SpringAppOrder.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Ordre {
    Integer id;
    List<Product> listproduit;
    double total_price;
    public Ordre(int id,List<Product>listproduit, double total_price){
        this.id=id++;
        this.listproduit=listproduit;
        this.total_price=total_price;
    }
}
