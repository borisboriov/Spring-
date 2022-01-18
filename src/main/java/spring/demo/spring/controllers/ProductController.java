package spring.demo.spring.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import spring.demo.spring.converters.ProductConverter;
import spring.demo.spring.dto.ProductDto;
import spring.demo.spring.entities.Product;
import spring.demo.spring.exceptions.ResourceNotFoundException;
import spring.demo.spring.service.ProductService;
import spring.demo.spring.validators.ProductValidator;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;

    @GetMapping()
    public Page<ProductDto> findAllProducts(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_rate", required = false) Integer minRate,
            @RequestParam(name = "max_rate", required = false) Integer maxRate,
            @RequestParam(name = "title_part", required = false) String titlePart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(minRate, maxRate, titlePart, page).map(p -> productConverter.entityToDto(p));
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found id# " + id));
        return productConverter.entityToDto(product);
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.save(product); //у него product = ...save(product);???
        return productConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        productValidator.validate(productDto);
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }

// Этот метод выдает такую ошибку:
//Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long';
// nested exception is java.lang.NumberFormatException: For input string: "undefined"]
// не могу понять почему в метод не долетает корректные данные
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Long id) {
        productService.deleteByID(id);
    }


    @GetMapping("/change_rate")
    public void changeRate(@RequestParam(name = "id") Long productId, @RequestParam(name = "delta") Integer delta) {
        productService.changeRate(productId, delta);
    }



}