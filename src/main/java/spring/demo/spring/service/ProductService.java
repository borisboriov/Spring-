package spring.demo.spring.service;

import org.springframework.stereotype.Service;
import spring.demo.spring.model.Product;
import spring.demo.spring.model.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changeRate(Long productId, Integer delta) {
        Product product = productRepository.findById(productId);
        product.setRate(product.getRate() + delta);

    }
}
