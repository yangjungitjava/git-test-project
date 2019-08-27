package com.baidu.service;

import com.baidu.mapper.StudentMapper;
import com.baidu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpI implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> List(String mohu) {
        return studentMapper.List(mohu);
    }

    @Override
    public Student selectById(Student student) {
        return studentMapper.selectById(student);
    }
}
