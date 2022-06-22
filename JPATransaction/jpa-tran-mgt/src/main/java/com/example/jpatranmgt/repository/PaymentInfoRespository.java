package com.example.jpatranmgt.repository;

import com.example.jpatranmgt.entity.PaymentInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRespository extends JpaRepository<PaymentInfo, Integer> {
    
}
