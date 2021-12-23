package spring.demo.spring.repository;


import org.springframework.stereotype.Component;
import spring.demo.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {

    private List<Product> productList;


    @PostConstruct
    public void init() {
        productList = new ArrayList<>(List.of(
                new Product(1L, "Milk", 20, 10),
                new Product(2L, "Bread", 35, 20),
                new Product(3L, "Meat", 44, 30)
        ));
    }


    public List<Product> findAll() {
        return productList.stream().collect(Collectors.toUnmodifiableList());
    }


    public Product findById(Long id) {
        return productList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().get();

    }

    public void deleteById(Long id) {
        productList.removeIf(s -> s.getId().equals(id));
    }


}
