package spring.demo.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring.demo.spring.entities.Product;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {


    List<Product> findAllByCostBetween(Integer min, Integer max);

    List<Product> findAllByCostGreaterThan(Integer min);

    List<Product> findAllByCostIsLessThan(Integer max);
}