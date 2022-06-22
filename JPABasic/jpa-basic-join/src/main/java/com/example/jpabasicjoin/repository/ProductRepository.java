package com.example.jpabasicjoin.repository;

import com.example.jpabasicjoin.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
