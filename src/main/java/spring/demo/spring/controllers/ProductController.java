package spring.demo.spring.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.spring.entities.Product;
import spring.demo.spring.exeptions.ResourceNotFoundException;
import spring.demo.spring.services.ProductService;

import java.nio.file.ReadOnlyFileSystemException;
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

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found, id:" + id));
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


    @GetMapping("/products/find_between")
    public List<Product> findMax(@RequestParam(required = false) int min , @RequestParam(required = false) int max){
        return productService.findAllByCostBetween(min, max);
    }

    @GetMapping("/products/find_greater")
    public List<Product> findGreaterThen(@RequestParam(required = false) int min){
        return productService.findGreaterThen(min);
    }

    @GetMapping("/products/find_less")
    public List<Product> findLessThen(@RequestParam(required = false) int max){
        return productService.findLessThen(max);
    }

}
//3 К запросу всех товаров добавьте возможность фильтрации по минимальной и максимальной цене
// (в трех вариантах: товары дороже min цены, товары дешевле max цены, или товары,
// цена которых находится в пределах min-max).

