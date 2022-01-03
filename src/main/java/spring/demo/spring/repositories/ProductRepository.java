package spring.demo.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.demo.spring.entities.Product;


@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {



}
