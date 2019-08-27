package com.baidu.mapper;

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
     * 列表
     */
    @Select("select * from good where name like'%${mohu}%'")
    List<User> list(@Param("mohu") String mohu);
    /**
     * 批量删除
     */
    @Delete("delete from good where id=#{ids}")
    void plsc(@Param("ids") String ids);
    /**
     * 新建
     */
    @Insert("insert into good set name=#{name} ,stack=#{stack}")
    void insert(User user);
    /**
     * 修改回显
     */
    @Select("select * from good where id=#{id}")
    User selectById(User user);
    /**
     * 修改
     */
    @Update("update good set name=#{name} ,stack=#{stack} where id=#{id}")
    void update(User user);
    /**
     * 开启
     */
    @Update("update good set stack=1")
    void kaiqi(User user);
    /**
     * 屏蔽
     */
    @Update("update good set stack=0")
    void pinbi(User user);
}
