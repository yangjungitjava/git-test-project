package com.baidu.mapper;

import com.baidu.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IGoodsMapper {
    /**
     * 列表模糊
     */
    @Select(" SELECT *from t_goods where cname like '%${mohu}%'")
    List<Goods> selectGoods(@Param("mohu") String mohu);

    /**
     * 添加
     */
    @Insert(" insert into t_goods set cid=#{cid},cname=#{cname},first=#{first},two=#{two},count=#{count} ")
    void add(Goods goods);

    /**
     * 删除
     */
    @Delete(" delete from t_goods where id=#{id}")
    void del(Goods goods);

    /**
     * 修改回显
     */
    @Select("select * from t_goods where id=#{id}")
    Goods selectGoodsById(Goods goods);

    /**
     * 修改
     */
    @Insert(" update t_goods set cid=#{cid},cname=#{cname},first=#{first},two=#{two},count=#{count} where id=#{id}")
    void update(Goods goods);


}
