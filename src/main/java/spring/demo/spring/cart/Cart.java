package spring.demo.spring.cart;

import lombok.Data;
import org.springframework.stereotype.Component;
import spring.demo.spring.entities.Product;

import java.util.List;

@Component
@Data
public class Cart {

    private final List<Product> productList;


    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> findAll() {
        return productList;
    }

    public void deleteById(Long id) {
        productList.remove(id);
    }

    public void clear() {
        productList.clear();
    }
}
