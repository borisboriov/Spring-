package spring.demo.spring.Dao;

import org.springframework.stereotype.Component;
import spring.demo.spring.model.Product;

import java.util.List;


@Component
public interface ProductDao {

    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    void save(Product product);
    void update(Product product);
}
