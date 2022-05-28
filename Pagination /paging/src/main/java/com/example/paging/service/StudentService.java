package com.example.paging.service;

import java.util.List;

import com.example.paging.model.Student;
import com.example.paging.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Student> pageResult = repository.findAll(paging);
        return pageResult.toList();
    }
    
}
