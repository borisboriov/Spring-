package spring.demo.spring.services;


import org.springframework.stereotype.Service;
import spring.demo.spring.entities.Product;
import spring.demo.spring.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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

//    public List<Product> findByPrice(int min, int max) {
//        return productRepository.and
//    }
}
