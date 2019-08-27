package com.baidu.Service;

import com.baidu.pojo.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserService {
    /**
     * 登录
     */
    User login(User user);
    /**
     * 列表
     */
    PageInfo list(Integer page,Integer size, String mohu);
    /**
     * 批量删除
     */
    void plsc(String split[]);
    /**
     * 新建或者修改
     */
    void editor(User user);
    /**
     * 修改回显
     */
    User selectById(User user);
    /**
     * 开启
     */
    void kaiqi(User user);
    /**
     * 屏蔽
     */
    void pinbi(User user);
}
