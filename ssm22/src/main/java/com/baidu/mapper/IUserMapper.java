package com.baidu.mapper;

import com.baidu.entity.User;
import com.baidu.entity.User_goods;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface IUserMapper {
    /**
     * 登陆
     */
    @Select("select * from user u left join role r on u.rid=r.rid where name=#{name} and password=#{password}")
    User login(User user);

    /**
     * 菜品名称使用下拉框实现，需要从数据库中查出
     */
    @Select("select * from goods  ")
    List<User_goods> selectGoods();

    /**
     * 发布订单功能
     */
    @Insert("insert into user_goods (userid,gid,address,ugtime,state) values (#{userid},#{gid},#{address},now(),0)")
    void addOrder(User_goods order);

    /**
     * 用户角色：查看订单列表功能
     */
    @Select("SELECT * from user_goods ug LEFT JOIN goods g on ug.gid=g.gid WHERE ug.userid=#{userid}")
    List<User_goods> GoodsList(@Param("userid") String userid);

    /**
     * 快递员角色：查看所有用户发布的订单
     */
    @Select("SELECT * from user_goods ug LEFT JOIN goods g on ug.gid=g.gid\n" +
            "LEFT JOIN user u on u.userid=ug.userid")
    List<User_goods> GoodsAll();

    /**
     * 快递员角色：选择一个点单，点击“完成配送”按钮，使该订单状态修改为：已完成
     */
    @Update("update user_goods set state=1 where userid=#{userid} and gid=#{gid}")
    void updateGoods(@Param("userid") String userid, @Param("gid") String gid);

}
