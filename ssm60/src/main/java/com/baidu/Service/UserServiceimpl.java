package com.baidu.Service;

import com.baidu.mapper.UserMapper;
import com.baidu.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService{
   @Autowired
   private UserMapper mapper;
    /**
     * 登录
     */
    @Override
    public User login(User user) {
        return mapper.login(user);
    }
    /**
     * 列表
     */
    @Override
    public PageInfo list(Integer page, Integer size, String mohu) {
        PageHelper.startPage(page,size);
        List<User> list = mapper.list(mohu);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    /**
     * 批量删除
     */
    @Override
    public void plsc(String[] split) {
        for (String s : split) {
            mapper.plsc(s);
        }
    }
    /**
     * 新建或者修改
     */
    @Override
    public void editor(User user) {
        if(user.getId()==null){
            mapper.insert(user);
        }else{
            mapper.update(user);
        }
    }


    /**
     * 修改回显
     */
    @Override
    public User selectById(User user) {
        return mapper.selectById(user);
    }
    /**
     * 开启
     */
    @Override
    public void kaiqi(User user) {
        mapper.kaiqi(user);
    }
    /**
     * 屏蔽
     */
    @Override
    public void pinbi(User user) {
        mapper.pinbi(user);
    }
}
