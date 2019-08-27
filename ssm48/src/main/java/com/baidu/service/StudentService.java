package com.baidu.service;

import com.baidu.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> List(String mohu);
    Student selectById(Student student);
}
