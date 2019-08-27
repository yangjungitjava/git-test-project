package com.baidu.service;

import com.baidu.pojo.Good;
import com.baidu.pojo.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    /**
     * 登录
     */
    User login(User user);
    /**
     * 列表页面
     */
    PageInfo goodList(String mohu,Integer page,Integer size);
    /**
     * 历史记录
     */
    List<Good> histoty();
    /**
     * 添加或者修改
     */
    void editor(Good good);
    /**
     * 修改回显
     */
    Good selectGoodById(Good good);
}
