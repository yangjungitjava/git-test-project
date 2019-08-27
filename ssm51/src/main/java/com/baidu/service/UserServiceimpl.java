package com.baidu.service;

import com.baidu.mapper.UserMapper;
import com.baidu.pojo.Information;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceimpl implements UserService{
   @Autowired
   private UserMapper userMapper;


    @Override
    public PageInfo Information(String mohu, Integer page, Integer size, String time) {
        PageHelper.startPage(page,size);
        List<Information> informationList = userMapper.selectList(mohu,time);
        PageInfo<Information> pageInfo = new PageInfo<>(informationList);
        return pageInfo;
    }

    @Override
    public Information selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public Information login(Information information) {
        return userMapper.login(information);
    }

    @Override
    public void add(Information information) {
        userMapper.add(information);
    }

    @Override
    public List<Information> selectByType() {
        return userMapper.selectByType();
    }

    @Override
    public int unique(Information information) {
        return userMapper.unique(information);
    }

    @Override
    public void updateUser(Information information) {
        userMapper.updateUser(information);
    }
    @Override
    public void plsc(String[] split) {
        for (String s : split) {
            userMapper.plsc(s);
        }
    }
}
