package com.example.paging.service;

import java.util.List;

import com.example.paging.model.Student;

public interface IStudentService {
    List<Student> findPaginated(int pageNo, int pageSize);
}
