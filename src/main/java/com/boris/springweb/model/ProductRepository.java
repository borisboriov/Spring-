package com.boris.springweb.model;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {

    private List<Product> productList;


    @PostConstruct
    public void init() {
        productList = new ArrayList<>(List.of(
                new Product(1L, "Milk", 20),
                new Product(2L, "Bread", 35),
                new Product(3L, "Meat", 44)
        ));
    }

    public List<Product> findAll() {
        return productList.stream().collect(Collectors.toUnmodifiableList());
    }

    public Product findById(Long id) {
        return productList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


    //    public Product showProductById(Long id) {
//        return productList.get(Math.toIntExact(id));
//    }

}
