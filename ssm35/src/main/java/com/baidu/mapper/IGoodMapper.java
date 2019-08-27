package com.baidu.mapper;

import com.baidu.entity.Good;
import com.baidu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IGoodMapper {
    /**
     * 登录
     */
    @Select("select * from t_user where username=#{username} and pwd=#{pwd}")
    User login(User user);
    /**
     * 模糊加分页
     */
    @Select("SELECT * from t_good g LEFT JOIN\n" +
            " t_type t on g.cid=t.cid LEFT JOIN\n" +
            "t_brand b on g.pid=b.pid where gname\n" +
            "like '%${mohu}%' and price BETWEEN 0 \n" +
            "and 100000")
    List<Good> GoodList(@Param("mohu") String mohu);
    /**
     * 批量删除
     */
    @Delete("delete from t_good where gid=#{ids}")
    void plsc(@Param("ids") String ids);
    //添加
    @Insert("insert into t_good set gname=#{gname},price=#{price},count=#{count}")
    void add(Good good);






















































































}
