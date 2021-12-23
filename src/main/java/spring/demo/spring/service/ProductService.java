package spring.demo.spring.service;

import org.springframework.stereotype.Service;
//import spring.demo.spring.Dao.ProductDaoImpl;
import spring.demo.spring.Dao.ProductDaoImpl;
import spring.demo.spring.model.Product;
import spring.demo.spring.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
     private final ProductRepository productRepository;
     private final ProductDaoImpl productDao;

    public ProductService(ProductRepository productRepository, ProductDaoImpl productDao) {
        this.productRepository = productRepository;
        this.productDao = productDao;
    }


    public Product findById(Long id){
            return productDao.findById(id);
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void save(Product product){
        productDao.save(product);
    }

    public void changeRate(Long productId, Integer delta) {
        Product product = productRepository.findById(productId);
        product.setRate(product.getRate() + delta);

    }
}
