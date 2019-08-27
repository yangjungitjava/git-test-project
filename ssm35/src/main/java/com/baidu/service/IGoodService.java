package com.baidu.service;

import com.baidu.entity.Good;
import com.baidu.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGoodService {
    /**
     * 登录
     */
    User login(User user);
    /**
     * 模糊加分页
     */
    PageInfo GoodList(String mohu,Integer page,Integer size);
    /**
     * 批量删除
     */
    void plsc( String split[]);
    //添加
    void add(Good good);






















































































}
