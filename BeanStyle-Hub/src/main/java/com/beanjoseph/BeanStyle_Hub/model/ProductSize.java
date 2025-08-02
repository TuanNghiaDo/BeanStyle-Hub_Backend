package com.beanjoseph.BeanStyle_Hub.model;

import jakarta.persistence.*;

@Entity // BẮT BUỘC phải là Entity
@Table(name = "product_sizes")
public class ProductSize {

    @EmbeddedId // Đánh dấu đây là khóa chính nhúng
    private ProductSizeId id;

    @ManyToOne
    @MapsId("productId") // Map thuộc tính productId trong ProductSizeId
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("sizeId") // Map thuộc tính sizeId trong ProductSizeId
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(nullable = false)
    private int amount; // Đây là lý do chúng ta phải tạo Entity này
}