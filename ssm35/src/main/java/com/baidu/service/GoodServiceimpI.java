package com.baidu.service;

import com.baidu.entity.Good;
import com.baidu.entity.User;
import com.baidu.mapper.IGoodMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceimpI implements IGoodService{
    @Autowired
    private IGoodMapper mapper;
    /**
     * 登录
     */
    @Override
    public User login(User user) {
        return mapper.login(user);
    }
    /**
     * 模糊加分页
     */
    @Override
    public PageInfo GoodList(String mohu, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Good> goodList = mapper.GoodList(mohu);
        PageInfo<Good> pageInfo = new PageInfo<>(goodList);
        return pageInfo;
    }
    /**
     * 批量删除
     */
    @Override
    public void plsc(String[] split) {
        for (String ids:split) {
            mapper.plsc(ids);
        }
    }
    //添加
    @Override
    public void add(Good good) {
        mapper.add(good);
    }


}
