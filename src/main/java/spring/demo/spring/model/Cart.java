package spring.demo.spring.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Cart {

    private Map<Product, Integer> productsInCart;

    @Autowired
    ProductRepository productRepository;

    public Cart() {
        productsInCart = new ConcurrentHashMap<>();
    }


    public void addItem(int id) {
        Product product = productRepository.findById(id);
        productsInCart.put(product, product.getId());
        System.out.println("Продукт -" + product.getTitle() + "Добавлен" + "\nֿֿֿ");
    }

    public void clearCart() {
        productsInCart.clear();
        System.out.println("Корзина очищена" + "\n");
    }

    public void removeItem(int id) {
        Product product = productRepository.findById(id);
        productsInCart.remove(product);
    }

    public void cartView() {
        if (productsInCart.isEmpty()) {
            System.out.println("корзина пуста" + "\n");
        } else {
            System.out.println("Содржание корзины: " + productsInCart + "\n");
        }
    }


}
