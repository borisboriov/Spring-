package spring.demo.spring.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.spring.entities.Product;
import spring.demo.spring.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteByID(@PathVariable Long id) {
        productService.deleteByID(id);
    }

    //для сохранения продукта тут, пришлось создать отдельный конструктор без инта в сигнатуре
    @GetMapping("/products/save/")
    public void save(@RequestParam String title, @RequestParam int cost) {
        productService.save(new Product(title, cost));
    }


//    @GetMapping("/products/search")
//    public List<Product> findByPrice(@RequestParam(required = false) int min , @RequestParam(required = false) int max){
//        return productService.findByPrice(min, max);
//    }

}
//3 К запросу всех товаров добавьте возможность фильтрации по минимальной и максимальной цене
// (в трех вариантах: товары дороже min цены, товары дешевле max цены, или товары,
// цена которых находится в пределах min-max).

