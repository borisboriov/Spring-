package spring.demo.spring.validators;


import org.springframework.stereotype.Component;
import spring.demo.spring.dto.ProductDto;
import spring.demo.spring.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    public void validate(ProductDto productDto){
        List<String> errors = new ArrayList<>();
        if (productDto.getCost() < 1){
            errors.add("Price less then 1! ");
        }
        if (productDto.getTitle().isBlank()){
             errors.add("Title input cant be  empty");
        }
        if (!errors.isEmpty()){
            throw  new ValidationException(errors);
        }
    }


}
