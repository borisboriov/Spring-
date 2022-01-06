package spring.demo.spring.service;


import org.springframework.stereotype.Service;
import spring.demo.spring.entities.Product;
import spring.demo.spring.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


//    public void changeRate(Long productId, Integer delta) {
//        Product product = productRepository.findById(productId);
//        product.setRate(product.getRate() + delta);
//
//    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteByID(Long id) {
        productRepository.deleteById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAllByCostBetween(int min, int max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public List<Product> findGreaterThen(int min) {
        return productRepository.findAllByCostGreaterThan(min);
    }

    public List<Product> findLessThen(int max) {
        return productRepository.findAllByCostIsLessThan(max);
    }
}
