package com.baidu.mapper;

import com.baidu.pojo.Information;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * from information i LEFT JOIN\n" +
            "type t on i.department=t.cid where name like '%${mohu}%' and i.time like '%${time}%' ")
    List<Information> selectList(@Param("mohu") String mohu,@Param("time") String time );
    @Select("SELECT * from information i LEFT JOIN type t on i.department=t.cid where id=#{id}")
    Information selectById(@Param("id") Long id);
    @Select("SELECT * from user where username=#{username} and pwd=#{pwd}")
    Information login(Information information);
    @Insert("insert into information set zhanghao=#{zhanghao},name=#{name},age=#{age},department=#{department},hobby=#{hobby},time=#{time},img=#{img}")
    void add(Information information);
    @Select("select * from type")
    List<Information> selectByType();
    @Select("select count(*) from information where zhanghao=#{zhanghao}")
    int unique(Information information);
    @Update("update information set zhanghao=#{zhanghao},name=#{name},age=#{age},department=#{department},hobby=#{hobby},time=#{time},department=#{department} where id=#{id}")
    void updateUser(Information information);
    @Delete("delete from information where id=#{ids}")
    void plsc(@Param("ids") String ids);





}
