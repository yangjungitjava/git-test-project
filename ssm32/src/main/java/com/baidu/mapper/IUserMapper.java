package com.baidu.mapper;

import com.baidu.entity.Order;
import com.baidu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserMapper {
    @Select("select * from t_user where uname=#{uname} and pwd=#{pwd}")
    User login(User user);

    @Select("select * from t_order where oname like '%${mohu}%'")
    List<Order> selectOrder(@Param("mohu") String mohu);

    @Delete("delete from t_order where oid=#{ids}")
    void plsc(@Param("ids") String ids);

    @Select("select * from t_type")
    List<Order> selectType();

    @Insert("insert into t_order set ooid=#{ooid},cname=#{cname},beizhu=#{beizhu},qixian=#{qixian},qtime=#{qtime},ytime=#{ytime}")
    void addOrder(Order order);


































}
