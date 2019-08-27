package com.baidu.controller;

import com.baidu.pojo.Student;
import com.baidu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("list")
    public String list(String mohu, Map<String,Object> map){
        mohu=mohu==null?"":mohu;
        List<Student> list = studentService.List(mohu);
        map.put("mohu",mohu);
        map.put("list",list);
        return "list";
    }
    @RequestMapping("selectById")
    public String selectById(Student student, Map<String,Object> map){
        Student selectById = studentService.selectById(student);
        map.put("s",selectById);
        return "update";
    }
}
