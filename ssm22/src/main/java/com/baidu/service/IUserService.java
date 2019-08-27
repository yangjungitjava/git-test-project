package com.baidu.service;

import com.baidu.entity.User;
import com.baidu.entity.User_goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    /**
     * 登陆
     */
    User login(User user);

    /**
     * 菜品名称使用下拉框实现，需要从数据库中查出
     */
    List<User_goods> selectGoods();

    /**
     * 发布订单功能
     */
    void addOrder(User_goods order);

    /**
     * 用户角色：查看订单列表功能
     */
    List<User_goods> GoodsList(String userid);

    /**
     * 快递员角色：查看所有用户发布的订单
     */
    List<User_goods> GoodsAll();

    /**
     * 快递员角色：选择一个点单，点击“完成配送”按钮，使该订单状态修改为：已完成
     */
    void updateGoods(@Param("userid") String userid, @Param("userid") String gid);
}
