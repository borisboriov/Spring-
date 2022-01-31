package spring.demo.spring.converters;


import org.springframework.stereotype.Component;
import spring.demo.spring.dto.ProductDto;
import spring.demo.spring.entities.Product;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost(), productDto.getRate());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getCost(), product.getRate());
    }
}
