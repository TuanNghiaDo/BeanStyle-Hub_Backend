package com.beanjoseph.BeanStyle_Hub.model;


import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProductSizeId implements Serializable {
    private Long productId;
    private Long sizeId;
}
