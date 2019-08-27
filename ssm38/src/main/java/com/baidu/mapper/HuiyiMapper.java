package com.baidu.mapper;

import com.baidu.entity.Huiyi;
import com.baidu.entity.Type;
import com.baidu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HuiyiMapper {
    /**
     * 登录
     */
    @Select("select * from t_user where uname=#{uname} and pwd=#{pwd}")
    User login(User user);
    /**
     * 列表
     */
    @Select("SELECT * FROM t_huiyi h LEFT JOIN t_type\n" +
            "t on h.cid=t.cid where hid like '%${mohu}%' ")
    List<Huiyi> List(@Param("mohu") String mohu);
    /**
     * 下拉
     */
    @Select("select * from t_type")
    List<Type> xl();
    /**
     * 添加
     */
    @Insert("insert into t_huiyi set cid=#{cid},hid=#{hid},count=#{count},tv=#{tv},touxing=#{touxing},kfyd=#{kfyd},sfky=#{sfky}")
    void add(Huiyi huiyi);
}
