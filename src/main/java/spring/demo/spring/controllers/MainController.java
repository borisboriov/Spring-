package spring.demo.spring.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/products/change_score")
    public void changeScore(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeRate(productId, delta);
    }


    //    @GetMapping("/products")
//    public String ShowProducts(Model model) {
//        model.addAttribute("products", productRepository.findAll());
//        return "products_page";
//    }
//
//    @GetMapping("/products/{id}")
//    public String ShowProduct(Model model, @PathVariable Long id) {
//        Product product = productRepository.findById(id);
//        model.addAttribute("product", product);
//        return "product_info_page";
//    }

}
