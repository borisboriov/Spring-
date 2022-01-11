package spring.demo.spring.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.demo.spring.entities.Product;
import spring.demo.spring.repositories.ProductRepository;
import spring.demo.spring.specifications.ProductSpecifications;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //с подключением spring data при выдергинвании продукта из репозитория требуется, что бы он был optional.
//я чего тут только не воротил, но метод так и не заработал. rate у продукта не меняется (при попытке изменить его с фронта)
    public void changeRate(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow(ReadOnlyFileSystemException::new);
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

    //old version
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
