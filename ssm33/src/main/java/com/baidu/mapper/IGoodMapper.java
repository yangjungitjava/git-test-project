package com.baidu.mapper;

import com.baidu.entity.Good;
import com.baidu.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IGoodMapper {
    /**
     * 列表模糊分页
     */
    @Select("SELECT g.*,t.cname FROM t_good g left join t_type t \n" +
            "on g.cid=t.cid WHERE name like '%${name}%'")
    List<Good> GoodList(@Param("name") String name);
    /**
     * 批量删除
     */
    @Delete("delete from t_good where id in(${ids})")
    void plsc(@Param("ids") String ids);
    /**
     * 查询下拉框
     */
    @Select("select * from t_type")
    List<Type> selectType();
    /**
     * 添加
     */
    @Insert("insert into t_good set name=#{name},content=#{content},price=#{price},qtime=#{qtime},gtime=#{gtime},cid=#{cid},img=#{img}")
    void add(Good good);












































}
