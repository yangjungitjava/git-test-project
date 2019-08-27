package com.baidu.mapper;

import com.baidu.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface IProductMapper {
    /**
     * 列表分页
     */
    @Select("SELECT * from t_product p LEFT JOIN\n" +
            "t_brand b on p.brand_id=b.bid\n" +
            "LEFT JOIN t_color c on p.color_id\n" +
            "=c.tid LEFT JOIN t_shop s on \n" +
            "p.shop_id=s.sid")
    List<Product> selectList();
    /**
     * 批量删除
     */
    @Delete("delete from t_product where id=#{ids}")
    void plsc(@Param("ids") String ids);
    /**
     * 获取颜色单选按钮
     */
    @Select("select * from t_color")
    List<Product> selectcolor();

















}
