package com.thiha.ecommerce;

import com.thiha.ecommerce.Product;
import com.thiha.ecommerce.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    //inject the constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //get the products
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    //find with productId
    @GetMapping("{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    //To add new products
    @PostMapping
    public void insertProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}