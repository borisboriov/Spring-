package spring.demo.spring.model;


import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Repository
@Data
public class ProductRepository {

    List<Product> productList = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init() {
        productList.add(new Product(1, "iphone", 10));
        productList.add(new Product(2, "ipad", 20));
        productList.add(new Product(3, "imac", 30));
        productList.add(new Product(4, "pods", 40));
        productList.add(new Product(5, "mouse", 50));
    }

    public Product findById(int id) {
        return productList.get(id - 1);
    }

}
