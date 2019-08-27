package com.baidu.service;

import com.baidu.entity.Order;
import com.baidu.entity.User;
import com.baidu.mapper.IUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpI implements IUserService{
    @Autowired
    private IUserMapper mapper;
    @Override
    public User login(User user) {
        return mapper.login(user);
    }

    @Override
    public PageInfo selectOrder(String mohu,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<Order> orderList = mapper.selectOrder(mohu);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        return pageInfo;
    }

    @Override
    public void plsc(String[] split) {
        for ( String ids:split) {
                mapper.plsc(ids);
        }
    }

    @Override
    public List<Order> selectType() {
        return mapper.selectType();
    }

    @Override
    public void addOrder(Order order) {
        mapper.addOrder(order);
    }


}
