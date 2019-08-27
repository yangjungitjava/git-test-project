package com.baidu.service;

import com.baidu.entity.Good;
import com.baidu.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IGoodService {
    /**
     * 登录
     */
    User login(User user);
    /**
     * 用户登录列表,用户：列表展示全部商品.
     */
    List<Good> Allgoods(User user);
    /**
     * 我购买的商品“列表
     */
    List<Good> MyGoodById( User user);
    /**
     * 购买商品后，将商品添加到我的商品列表中
     */
    void addGood(Good good);
    /**
     * 商家：列表展示自己发布的商品模糊加分页
     */
    PageInfo GoodList(User user ,String mohu,Integer page,Integer size);
    /**
     * 查询下拉框
     */
    List<Good> selectType();

    /**
     * 商家发布商品（10分
     */
    void insertGoods(User user);




























    /**
     * 7.商品修改功能（10分）
     */
    void updategood(User user);
    /**
     * 修改回显
     */
    Good updateById(Good good);













































































































}
