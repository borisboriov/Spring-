package spring.demo.spring.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.spring.entities.Product;
import spring.demo.spring.service.ProductService;

import java.util.List;


@RestController
public class MainController {

    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }


//
//    @GetMapping("/products/change_rate")
//    public void changeRate(@RequestParam Long productId, @RequestParam Integer delta) {
//        productService.changeRate(productId, delta);
//    }

}
