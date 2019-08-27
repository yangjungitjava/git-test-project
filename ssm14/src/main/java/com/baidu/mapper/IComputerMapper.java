package com.baidu.mapper;

import com.baidu.entity.Computer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IComputerMapper {
    /**
     * 列表模糊排序
     */
    @Select("SELECT c.*,o.*,t.* from computer c LEFT JOIN one o on c.oid=o.oid\n" +
            "LEFT JOIN two t on c.tid=t.tid where name like '%${name}%'  ORDER BY o.oid,t.tid,c.num")
    List<Computer> selectlist(@Param("name") String name);

    /**
     * 一级标题(以下拉框的形式展示)
     */
    @Select("SELECT * from one")
    List<Computer> selectOne();

    /**
     * 二级标题(以下拉框的形式展示,通过一级标题给出的oid来获得tid,然后以 下拉框的形式展示出来)
     */
    @Select("select * from two where oid = #{oid}")
    List<Computer> selectTwo(Integer oid);

    /**
     * 添加
     */
    @Insert("insert into computer set name=#{name},num=#{num},oid=#{oid},tid=#{tid}")
    void addCom(Computer computer);

    /**
     * 修改回显
     */
    @Select("SELECT * FROM computer c LEFT JOIN one o on c.oid=o.oid\n" +
            "LEFT JOIN two t on t.tid=c.tid where c.id=#{id}")
    Computer selectListById(Computer computer);

    /**
     * 修改
     */
    @Update("update computer set name=#{name},num=#{num},oid=#{oid},tid=#{tid} where id=#{id}")
    void updateCom(Computer computer);

    /**
     * 登陆
     */
    @Select("select * from computer where name=#{name}")
    Computer login(Computer computer);


}
