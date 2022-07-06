package com.example.paging.controller;

import java.util.List;

import com.example.paging.model.Student;
import com.example.paging.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private StudentService studentService; 

    @GetMapping("/student/{pageNo}/{pageSize}")
    public List<Student> getPaginated(@PathVariable int pageNo, @PathVariable int pageSize){
        return studentService.findPaginated(pageNo, pageSize);
    }
}
