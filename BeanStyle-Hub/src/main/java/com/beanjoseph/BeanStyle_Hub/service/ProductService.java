package com.beanjoseph.BeanStyle_Hub.service;

import com.beanjoseph.BeanStyle_Hub.dto.*;
import com.beanjoseph.BeanStyle_Hub.model.Product;
import com.beanjoseph.BeanStyle_Hub.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
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

    //Mapper DTOclass to Entity
    private ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());

        //convert ProductType
        if(product.getProductType() != null){
            ProductTypeDTO productTypeDTO = new ProductTypeDTO();
            productTypeDTO.setId(product.getProductType().getId());
            productTypeDTO.setName(product.getProductType().getName());
            productDTO.setProductType(productTypeDTO);
        }

        //convert List<Size>
        if(product.getProductSizes() != null){
            Set<SizeDTO> sizes = product.getProductSizes().stream().map(size -> {
                SizeDTO sizeDTO = new SizeDTO();
                sizeDTO.setName(size.getSize().getName());
                sizeDTO.setAmount(size.getAmount());
                return sizeDTO;
            }).collect(Collectors.toSet());
            productDTO.setSizes(sizes);
        }

        //convert images
        if(product.getImages() != null){
            Set<ProductImageDTO> imagesDTO = product.getImages().stream().map(image -> {
                ProductImageDTO imageDTO = new ProductImageDTO();
                imageDTO.setId(image.getId());
                imageDTO.setImageUrl(image.getImageUrl());
                return imageDTO;
            }).collect(Collectors.toSet());
        }

        if(product.getMaterials() != null){
            Set<MaterialDTO> materials = product.getMaterials().stream().map(material -> {
                MaterialDTO materialDTO = new MaterialDTO();
                materialDTO.setName(material.getName());
                materialDTO.setId(material.getId());
                return materialDTO;
            }).collect(Collectors.toSet());
        }

        return productDTO;
    }
}
