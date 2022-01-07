package spring.demo.spring.controllers;

import org.springframework.web.bind.annotation.*;
import spring.demo.spring.entities.Product;
import spring.demo.spring.exceptions.ResourceNotFoundException;
import spring.demo.spring.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found, id:" + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteByID(@PathVariable Long id) {
        productService.deleteByID(id);
    }

    @GetMapping("/products/save/")
    public void save(@RequestParam String title, @RequestParam Integer cost, @RequestParam Integer rate) {
        productService.save(new Product(title, cost, rate));
    }


    @GetMapping("/products/find_between")
    public List<Product> findMax(@RequestParam(required = false) int min, @RequestParam(required = false) int max) {
        return productService.findAllByCostBetween(min, max);
    }

    @GetMapping("/products/find_greater")
    public List<Product> findGreaterThen(@RequestParam(required = false) int min) {
        return productService.findGreaterThen(min);
    }

    @GetMapping("/products/find_less")
    public List<Product> findLessThen(@RequestParam(required = false) int max) {
        return productService.findLessThen(max);
    }

}