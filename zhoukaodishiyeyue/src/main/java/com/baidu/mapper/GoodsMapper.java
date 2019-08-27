package com.baidu.mapper;

import com.baidu.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    /**
     * 列表
     */
    @Select("SELECT * from goods g LEFT JOIN brand b ON\n" +
            "g.cid=b.cid LEFT JOIN type t on g.tid\n" +
            "=t.tid where name like '%${mohu}%'and g.price between #{begin} and #{end}")
    List<Goods> GoodsList(@Param("mohu") String mohu,@Param("begin") double begin ,@Param("end") double end);
    /**
     * 删除
     */
    @Delete("delete from goods where id=#{ids}")
    void plsc(@Param("ids") String ids);
    /**
     * 查询品牌
     */
    @Select("select * from brand")
    List<Goods> selectOne();
    /**
     * 查询类型
     */
    @Select("select * from type where cid=#{cid}")
    List<Goods> selectTwo(@Param("cid") Integer cid);
    /**
     * 添加
     */
    @Insert("insert into goods set name=#{name},price=#{price},count=#{count},cid=#{cid},tid=#{tid}")
    void add(Goods goods);
    /**
     * 修改回显
     */
    @Select("SELECT * from goods  where id=#{id}")
    Goods selectbyid(Goods goods);
    /**
     * 修改
     */
    @Update("update goods set name=#{name},price=#{price},count=#{count},cid=#{cid},tid=#{tid} where id=#{id}")
    void update(Goods goods);
}
