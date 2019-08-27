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
     * 用户登录列表,用户：列表展示全部商品.
     */
    @Override
    public List<Good> Allgoods(User user) {
        return mapper.Allgoods(user);
    }
    /**
     * 我购买的商品“列表
     */
    @Override
    public List<Good> MyGoodById( User user) {
        return mapper.MyGoodById(user);
    }
    /**
     * 购买商品后，将商品添加到我的商品列表中
     */
    @Override
    public void addGood(Good good) {
        mapper.addGood(good);
    }

    /**
     * 商家：列表展示自己发布的商品
     */
    @Override
    public PageInfo GoodList(User user ,String mohu,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        //调用mapper层的模糊列表方法
        List<Good> goodList = mapper.GoodList(user, mohu);
        //创建分页插件对象.并且把查询来的模糊列表对象传进去.
        PageInfo<Good> pageInfo = new PageInfo<>(goodList);
        return pageInfo;
    }
    /**
     * 查询下拉框
     */
    @Override
    public List<Good> selectType() {
        return mapper.selectType();
    }

    /**
     * 商家发布商品（10分
     */
    @Override
    public void insertGoods(User user) {
        mapper.insertGoods(user);
    }


















    /**
     * 7.商品修改功能（10分）
     */
    @Override
    public void updategood(User user) {
        mapper.updategood(user);
    }
    /**
     * 修改回显
     */
    @Override
    public Good updateById(Good good) {
        return mapper.updateById(good);
    }


}
