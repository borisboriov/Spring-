package spring.demo.spring.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.demo.spring.entities.Product;
import spring.demo.spring.exceptions.ResourceNotFoundException;
import spring.demo.spring.repositories.ProductRepository;
import spring.demo.spring.specifications.ProductSpecifications;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public void changeRate(Long productID, Integer delta) {
        Product product = productRepository.findById(productID).orElseThrow(() -> new ResourceNotFoundException("Unable to change product's rate. Product not found, id: " + productID));
        product.setRate(product.getRate() + delta);
    }

    public Page<Product> find(Integer minRate, Integer maxRate, String partTitle, Integer page) {
        Specification<Product> specification = Specification.where(null);
        if (minRate != null) {
            specification = specification.and(ProductSpecifications.rateGreaterOrEqualsThan(minRate));
        }
        if (maxRate != null) {
            specification = specification.and(ProductSpecifications.rateLessOrEqualsThan(maxRate));
        }
        if (partTitle != null) {
            specification = specification.and(ProductSpecifications.titleLike(partTitle));
        }
        return productRepository.findAll(specification, PageRequest.of(page - 1, 5));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteByID(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }


}
