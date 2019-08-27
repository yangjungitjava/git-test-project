package com.baidu.service;

import com.baidu.mapper.UserMapper;
import com.baidu.pojo.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public Product Login(Product product) {
        return userMapper.Login(product);
    }

    @Override
    public int unique(Product product) {
        return userMapper.unique(product);
    }

    @Override
    public List<Product> selectList() {
        return userMapper.selectList();
    }

    @Override
    public List<Product> selectType() {
        return userMapper.selectType();
    }

    @Override
    public void add(Product product) {
        userMapper.add(product);
    }

    @Override
    public void insert(Product product) {
        userMapper.insert(product);
    }


}
