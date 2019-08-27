package com.baidu.service;

import com.baidu.entity.Order;
import com.baidu.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserService {
    User login(User user);

    PageInfo selectOrder(String mohu,Integer page,Integer size);

    void plsc( String split[]);

    List<Order> selectType();

    void addOrder(Order order);
























}
