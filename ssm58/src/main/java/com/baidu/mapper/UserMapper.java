package com.baidu.mapper;

import com.baidu.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username} and pwd=#{pwd} ")
    Product Login(Product product);
    @Select("select count(*) from user where username=#{username}")
    int unique(Product product);
    @Select("SELECT * from product pt\n" +
            "LEFT JOIN prodescs pc ON\n" +
            "pt.`describess`=pc.pid order by id")
    List<Product> selectList();
    @Insert("insert into product set pname=#{pname},price=#{price},describess=#{describess}")
    void add(Product product);
    @Select("select * from prodescs")
    List<Product> selectType();
    @Insert("insert into orders set totalprice=#{price},orderdate=now()")
    void insert(Product product);
}
