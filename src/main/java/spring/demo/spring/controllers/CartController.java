package spring.demo.spring.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spring.demo.spring.converters.ProductConverter;
import spring.demo.spring.dto.ProductDto;
import spring.demo.spring.entities.Product;
import spring.demo.spring.service.CartService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductConverter productConverter;


    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Long id) {
        log.error("xx" + id);
        System.out.println(id);
        cartService.deleteByID(id);
    }

    @PostMapping("/add/")
    public List<Product> addProductToCart(@RequestBody ProductDto productDto) {
        Product product = productConverter.dtoToEntity(productDto);
        cartService.addToCart(product);
        return cartService.findAllInCart();
    }

    @DeleteMapping
    public List<Product> clearCart() {
        cartService.clearCart();
        return cartService.findAllInCart();
    }
}
