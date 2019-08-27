package com.baidu.mapper;

import com.baidu.entity.Computer;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    /**
     * 列表和模糊查询
     */
    @Select("SELECT * from t_computer c left join t_one o\n" +
            "on c.oid=o.oid left join t_two t on c.tid=\n" +
            "t.tid WHERE cname like '%${mohu}%' ORDER BY o.oid,t.tid,c.count"  )
    List<Computer> selectCom(@Param("mohu") String mohu);
    /**
     * 查询一级标题
     */
    @Select("select * from t_one")
    List<Computer> selectOne();
    /**
     * 查询二级标题
     */
    @Select("select * from t_two where oid=#{oid}")
    List<Computer> selectTwo(@Param("oid") Integer oid);
    /**
     * 添加
     */
    @Insert("insert into t_computer set ccid=#{ccid},cname=#{cname},count=#{count},oid=#{oid},tid=#{tid},img=#{img} ")
    void insertComputer(Computer computer);
    /**
     * 修改回显
     */
    @Select("SELECT * from t_computer c left JOIN\n" +
            "t_one o on o.oid=c.oid\n" +
            "left join t_two t on t.tid=c.tid\n" +
            "where cid=#{cid}")
    Computer selectCombyId(Integer cid);
    /**
     * 修改
     */
    @Update("update t_computer set ccid=#{ccid},cname=#{cname},count=#{count},oid=#{oid},tid=#{tid} where cid=#{cid}")
    void updateCom(Computer computer);
    /**
     * 删除
     */
    @Delete("delete from t_computer where cid=#{cid}")
    void delCom(Computer computer);
       /**
     * 登录
     */
    @Select("select * from t_computer where cname=#{cname}")
    Computer login(Computer computer);
    /**
     * 批量删除
     */
    @Delete("delete from t_computer where cid=#{ids}")//@Param("ids")ids是前台传过来的.
    void plsc(@Param("ids") String ids);






































}
