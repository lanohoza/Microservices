package com.orderapp.SpringAppOrder.service;

import com.orderapp.SpringAppOrder.models.Ordre;
import com.orderapp.SpringAppOrder.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    List<Ordre> listorder=new ArrayList<>();

    @Override
    public List<Ordre> findAll() {
        return listorder;
    }
    @Override
    public Ordre findById(int id) {
        return listorder
                .stream()
                .filter(ordre -> ordre.getId()==id)
                .findAny()
                .get();
    }

    @Override
    public List<Ordre> addOrder( int id,List<Product> listprod, double total_price) {
        Ordre ord=new Ordre(id,listprod,total_price);
        listorder.add(ord);
        return listorder;
    }



}
