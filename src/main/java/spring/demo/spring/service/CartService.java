package spring.demo.spring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.demo.spring.cart.Cart;
import spring.demo.spring.converters.ProductConverter;
import spring.demo.spring.dto.ProductDto;
import spring.demo.spring.entities.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final Cart cart;
    private final ProductConverter productConverter;

    public List<Product> findAllInCart() {
        return cart.findAll();
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void deleteByID(Long id) {
        cart.deleteById(id);
    }

    public void clearCart() {
        cart.clear();
    }
}
