package spring.demo.spring.DAO;

import spring.demo.spring.model.Product;

import java.util.List;

public interface ProductDao {

    Product findByID(Long id);
    List<Product> findAll();

}
