package com.baidu.service;

import com.baidu.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserService {
    Product Login(Product product);
    int unique(Product product);
    List<Product> selectList();
    List<Product> selectType();
    void add(Product product);
    void insert(Product product);
}
