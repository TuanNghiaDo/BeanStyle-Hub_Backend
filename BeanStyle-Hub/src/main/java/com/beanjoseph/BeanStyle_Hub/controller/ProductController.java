package com.beanjoseph.BeanStyle_Hub.controller;

import com.beanjoseph.BeanStyle_Hub.model.Product;
import com.beanjoseph.BeanStyle_Hub.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                 @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(productId, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build(); // Trả về status 204 No Content
    }
}
