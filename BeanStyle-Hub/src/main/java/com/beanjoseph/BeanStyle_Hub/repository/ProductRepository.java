package com.beanjoseph.BeanStyle_Hub.repository;

import com.beanjoseph.BeanStyle_Hub.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
