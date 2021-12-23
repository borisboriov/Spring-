package spring.demo.spring.controllers;


import org.springframework.web.bind.annotation.*;
import spring.demo.spring.model.Product;
import spring.demo.spring.service.ProductService;

import java.util.List;


@RestController
public class MainController {

    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }


    @GetMapping("/products/change_rate")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeRate(productId, delta);
    }

    @GetMapping("/products/find/{id}")
    public Product findProduct(@PathVariable Long id) {
        return   productService.findById(id);
    }
//реализовал save() таким образом, потому, что на фронте пока тяжеловато, а времени у меня нет((((
    @GetMapping("/products/save/{id}")
    public void save(@PathVariable Long id, @RequestParam String title, @RequestParam int cost, @RequestParam int rate){
        productService.save(new Product(id, title, cost, rate));
    }


}
