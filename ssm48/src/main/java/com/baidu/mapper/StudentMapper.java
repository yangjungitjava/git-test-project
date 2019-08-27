package com.baidu.mapper;

import com.baidu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student where name like '%${mohu}%'")
    List<Student> List(@Param("mohu") String mohu);
    @Select("select * from student where id=#{id}")
    Student selectById(Student student);
}
