package spring.demo.spring.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import spring.demo.spring.dto.ProductDto;
import spring.demo.spring.entities.Product;
import spring.demo.spring.exceptions.ResourceNotFoundException;
import spring.demo.spring.service.ProductService;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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
        return productService.find(minRate, maxRate, titlePart, page).map(ProductDto::new);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productService.save(new Product(productDto.getId(), productDto.getTitle(), productDto.getCost(), productDto.getRate()));
        return productDto;
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productService.findById(productDto.getId()).get();
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        product.setRate(productDto.getRate());
        productService.save(product);
        productDto = new ProductDto(product);
        return productDto;
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Long id) {
        productService.deleteByID(id);
    }


    @GetMapping("/change_rate")
    public void changeRate(@RequestParam(name = "id") Long productId, @RequestParam(name = "delta") Integer delta) {
        productService.changeRate(productId, delta);
    }


//    @GetMapping("/products/find_between")
//    public List<Product> find_between(@RequestParam(required = false) int min, @RequestParam(required = false) int max) {
//        return productService.findAllByCostBetween(min, max);
//    }
//
//    @GetMapping("/products/find_greater")
//    public List<Product> findGreaterThen(@RequestParam(required = false) int min) {
//        return productService.findGreaterThen(min);
//    }
//
//    @GetMapping("/products/find_less")
//    public List<Product> findLessThen(@RequestParam(required = false) int max) {
//        return productService.findLessThen(max);
//    }

}