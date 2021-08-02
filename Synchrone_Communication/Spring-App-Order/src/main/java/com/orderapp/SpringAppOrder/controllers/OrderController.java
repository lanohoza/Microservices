package com.orderapp.SpringAppOrder.controllers;


import com.orderapp.SpringAppOrder.models.Ordre;
import com.orderapp.SpringAppOrder.models.Product;
import com.orderapp.SpringAppOrder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController {
    int id=1;
    double total_price = 0;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService ordreService;

    private String BASE_URI="http://PRODUCT-SERVICE/product-service";
    List<Ordre> ordres=new ArrayList<>();

    @GetMapping("/add-product-to-order/{id}/{productId}")
    public List<Product> addProductOrder(@PathVariable("productId")int productId,@PathVariable("id")int id){
        Ordre ord=getOrdreById(id);

        String uri=BASE_URI+"/product-by-id/"+productId;
        Product product=restTemplate.getForObject(uri,Product.class);
        ord.getListproduit().add(product);
        total_price =total(ord.getListproduit());
        ord.setTotal_price(total_price);
        return ord.getListproduit();
    }

    @GetMapping("/remove-product-from-order/{id}/{productId}")
    public List<Product> removeProductOrder(@PathVariable("productId")int productid,@PathVariable("id")int id){
        Ordre ord=getOrdreById(id);
        String uri=BASE_URI+"/product-by-id/"+productid;
        Product product=restTemplate.getForObject(uri,Product.class);

        ord.getListproduit().remove(product);
        total_price =total(ord.getListproduit());
        ord.setTotal_price(total_price);
        return ord.getListproduit();
    }


    @GetMapping("/getorders")
    public List<Ordre> getOrdres(){
        return ordreService.findAll();
    }

    @GetMapping("/getorderById/{id}")
    public Ordre getOrdreById(@PathVariable("id")int id){
        return ordreService.findById(id);
    }

    @GetMapping("/add-order")
    public List <Ordre> addOrder(){
        total_price=0;
         List<Product>list=new ArrayList<>();
        ordres= ordreService.addOrder(id++,list,total_price);
        return ordres;
    }

public Double total(List<Product>list){
    total_price=0;
    for (Product pro:list) {
        total_price=total_price+pro.getPrice();
    }
    return total_price;
}

}
