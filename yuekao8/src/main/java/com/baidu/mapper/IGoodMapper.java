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
    @Select("select * from t_user u left join t_rose r on u.rid=r.rid where uname=#{uname} and pwd=#{pwd}")
    User login(User user);
    /**
     * 用户登录列表,用户：列表展示全部商品.
     */
    @Select("SELECT * from t_user u left join \n" +
            "t_rose r on u.rid=r.rid\n" +
            "left join t_good g on g.uid=u.uid\n" +
            "left join t_type t on t. cid=g.cid")
    List<Good> Allgoods(User user);
    /**
     * 我购买的商品“列表
     */
    @Select("SELECT * from t_user u left join \n" +
            "t_rose r on u.rid=r.rid\n" +
            "left join t_good g on g.uid=u.uid\n" +
            "left join t_type t on t. cid=g.cid\n" +
            "where g.uid=#{uid}")
        List<Good> MyGoodById( User user);
    /**
     * 购买商品后，将商品添加到我的商品列表中
     */
    @Insert("insert into t_good set uid=#{uid},gname=#{gname},price=#{price},gtime=#{gtime},shangjia=#{shangjia},cid=#{cid}")
    void addGood(Good good);
    /**
     * 商家：列表展示自己发布的商品模糊加分页
     */
    @Select("SELECT * from t_user u left join \n" +
            "t_rose r on u.rid=r.rid\n" +
            "left join t_good g on g.uid=u.uid\n" +
            "left join t_type t on t. cid=g.cid\n" +
            "where u.uid=#{u.uid} and gname like '%${mohu}%'")
    List<Good> GoodList (@Param("u") User user,@Param("mohu") String mohu);
    /**
     * 查询下拉框
     */
    @Select("SELECT * from t_type")
    List<Good> selectType();

    /**
     * 商家发布商品（10分
     */
    @Insert("insert into t_good(gid,gname,price,gtime,shangjia,cid,uid) values(null,#{gname},#{price},now(),#{shangjia},#{cid},#{uid})")
    void insertGoods(User user);






























    /**
     * 7.商品修改功能（10分）
     */
    @Update("update t_good set gname=#{gname}, price=#{price},gtime=#{gtime} where gid=#{gid}")
    void updategood(User user);
    /**
     * 修改回显
     */
    @Select("select * from t_good where gid=#{gid}")
    Good updateById(Good good);
































































































































}
