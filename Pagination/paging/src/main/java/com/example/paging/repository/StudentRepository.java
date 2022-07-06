package com.example.paging.repository;

import com.example.paging.model.Student;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {
    
}
