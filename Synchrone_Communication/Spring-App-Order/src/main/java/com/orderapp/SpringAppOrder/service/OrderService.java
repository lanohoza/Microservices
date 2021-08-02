package com.orderapp.SpringAppOrder.service;

import com.orderapp.SpringAppOrder.models.Ordre;
import com.orderapp.SpringAppOrder.models.Product;

import java.util.List;

public interface OrderService {

    List<Ordre> findAll();
    Ordre findById(int id);
    List<Ordre>  addOrder(int id,List<Product>listprod, double total_price);
}
