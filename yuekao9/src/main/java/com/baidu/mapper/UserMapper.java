package com.baidu.mapper;

import com.baidu.pojo.Good;
import com.baidu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 登录
     */
    @Select("select * from user where uname=#{uname} and pwd=#{pwd}")
    User login(User user);
    /**
     * 列表页面
     */
    @Select("SELECT * from good g LEFT JOIN type t\n" +
            "on g.id=t.did where `name` like '%${mohu}%'")
    List<Good> goodList(@Param("mohu") String mohu);
    /**
     * 历史记录
     */
    @Select("SELECT * from good g LEFT JOIN type t\n" +
            "on g.id=t.did ")
    List<Good> histoty();
    /**
     * 添加
     */
    @Insert("insert into good set name=#{name},status=#{status},applydate=#{applydate},rank=#{rank}")
    void add(Good good);
    /**
     * 修改回显
     */
    @Select("SELECT * from good g LEFT JOIN type t\n" +
            "on g.id=t.did where id=#{id}")
    Good selectGoodById(Good good);
    /**
     * 修改
     */
    @Update("update good set name=#{name},status=#{status},applydate=#{applydate},rank=#{rank} where id=#{id}")
    void update(Good good);

}
