package com.beanjoseph.BeanStyle_Hub.dto;
import com.beanjoseph.BeanStyle_Hub.model.Material;

import java.math.BigDecimal;
import java.util.Set;

public class ProductDTO {
    private Long id;
    private String uuid;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductTypeDTO productType;
    private Set<ProductImageDTO> images;
    private Set<SizeDTO> sizes;
    private Set<MaterialDTO> materials;

    public Set<SizeDTO> getSizes() {
        return sizes;
    }

    public void setSizes(Set<SizeDTO> sizes) {
        this.sizes = sizes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public Set<ProductImageDTO> getImages() {
        return images;
    }

    public void setImages(Set<ProductImageDTO> images) {
        this.images = images;
    }

    public Set<MaterialDTO> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<MaterialDTO> materials) {
        this.materials = materials;
    }
}
