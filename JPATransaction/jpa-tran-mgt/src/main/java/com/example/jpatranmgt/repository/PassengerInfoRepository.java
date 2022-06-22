package com.example.jpatranmgt.repository;

import com.example.jpatranmgt.entity.PassengerInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Integer> {
    
}
