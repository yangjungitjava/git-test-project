package com.baidu.service;

import com.baidu.mapper.UserMapper;
import com.baidu.pojo.Good;
import com.baidu.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpI implements UserService{
    @Autowired
    private UserMapper userMapper;
    /**
     * 登录
     */
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
    /**
     * 列表页面
     */
    @Override
    public PageInfo goodList(String mohu, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Good> goodList = userMapper.goodList(mohu);
        PageInfo<Good> pageInfo = new PageInfo<>(goodList);
        return pageInfo;
    }
    /**
     * 历史记录
     */
    @Override
    public List<Good> histoty() {
        return userMapper.histoty();
    }

    /**
     * 添加和修改
     * @param good
     */
    @Override
    public void editor(Good good) {
        if(good.getId()==null){
            //执行修改
            userMapper.update(good);
        }else {
            //执行添加
            userMapper.add(good);
        }
    }

    /**
     * 修改回显
     */
    @Override
    public Good selectGoodById(Good good) {
        return userMapper.selectGoodById(good);
    }
}
