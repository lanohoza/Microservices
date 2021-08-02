package com.productapp.springproductappproduct.service;

import com.productapp.springproductappproduct.models.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public List<Product> findAll(){
        return showProductList();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return showProductList()
                .stream()
                .filter((product -> product.getCategory().equals(category)))
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(int id) {
        return showProductList()
                .stream()
                .filter((product) -> product.getProductId()==id)
                .findAny()
                .get();
                 }

private List<Product> showProductList(){
        return Arrays.asList(
                new Product(1,"Vivo Book","Asus","Laptops",20000),
                new Product(2,"Ideapad S340","Lenova","Laptops",32000),
                new Product(3,"Galaxy M10","Samsung","Mobiles",22000),
                new Product(4,"K6 Note","Lenova","Mobiles",9000),
                new Product(5,"HD Smart TV","Samsung","TV",65000),
                new Product(6,"Thinkpad T430","Lenova","Laptops",62000),
                new Product(7,"Ultra HD Smart","Sony","TV",22000),
                new Product(8,"Dell Inspiron","Dell","Laptops",70000)
        );
}
}
