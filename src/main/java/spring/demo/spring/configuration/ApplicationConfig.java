package spring.demo.spring.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.demo.spring.model.Cart;
import spring.demo.spring.model.ProductRepository;

@Configuration
@ComponentScan(basePackages = "spring.demo.spring")
public class ApplicationConfig {

    @Bean
    ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    Cart cart() {
        return new Cart();
    }

}
