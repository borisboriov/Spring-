package spring.demo.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.demo.spring.entities.Product;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String title;

    private int cost;

    private int rate;

    public ProductDto(Product product) {
    }
}
