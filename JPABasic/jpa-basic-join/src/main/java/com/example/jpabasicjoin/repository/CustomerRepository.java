package com.example.jpabasicjoin.repository;

import java.util.List;

import com.example.jpabasicjoin.dto.OrderResponse;
import com.example.jpabasicjoin.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.example.jpabasicjoin.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
