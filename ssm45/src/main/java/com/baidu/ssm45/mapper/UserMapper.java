package com.baidu.ssm45.mapper;

import com.baidu.ssm45.pojo.Good;
import com.baidu.ssm45.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select("SELECT * from good g LEFT JOIN\n" +
            "t_cid c on g.cid=c.cid\n" +
            "LEFT JOIN t_tid t on t.tid\n" +
            "=g.tid where gname like '%${mohu}%'")
    List<Good> ListGood(@Param("mohu") String mohu);

    /**
     * 批量删除
     * @param s
     */
    @Select("delete from good where gid=#{s}")
    void plsc(@Param("s") String s);
    /**
     * 添加1
     */
    @Select("select * from t_cid")
     List<Good>add1();
    /**
     * 添加2
     */
    @Select("select * from t_tid where cid=#{cid}")
    List<Good>add2(@Param("cid") Integer cid);
    /**
     *
     * 正式添加
     */
    @Insert("insert into good set cid=#{cid},tid=#{tid},time=#{time},gname=#{gname},img=#{img}")
    void insert(Good good);
}
