package com.baidu.mapper;

import com.baidu.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface GoodMapper {
    /**
     * 列表
     */
    @Select("SELECT * from good g LEFT JOIN\n" +
            "brand b on g.bid=b.bid where gname like '%${mohu}%'and gid like '%${gid}%'")
    List<Good> selectList(@Param("mohu") String mohu,@Param("gid") String gid);
    /**
     * 价格调整回显
     */
    @Select("select * from good where id=${id}")
    Good selectById(Good good);
    /**
     * 价格调整
     */
    @Update("update good set price=#{price} where id=#{id}")
    void update(Good good);
    /**
     * 仅显示有货
     */
    @Select("select * from good where kuncun>0")
    List<Good> youhuo();
}
