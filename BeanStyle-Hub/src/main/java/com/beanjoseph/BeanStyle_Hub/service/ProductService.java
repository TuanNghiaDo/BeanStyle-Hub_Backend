package com.beanjoseph.BeanStyle_Hub.service;

import com.beanjoseph.BeanStyle_Hub.model.Product;
import com.beanjoseph.BeanStyle_Hub.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product productDetails) {
        Product existingProduct = getProductById(productId);


        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setDescription(productDetails.getDescription());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long productId) {
        Product existingProduct = getProductById(productId);
        productRepository.delete(existingProduct);
    }
}
