package com.boris.springweb.controllers;


import com.boris.springweb.model.Product;
import com.boris.springweb.model.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String ShowProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String ShowProduct(Model model, @PathVariable Long id){
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

}
