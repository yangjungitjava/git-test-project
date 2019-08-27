package com.baidu.mapper;

import com.baidu.entity.Clazz;
import com.baidu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserMapper {
    /**
     * 登陆
     */
    @Select("SELECT * from user u LEFT JOIN role r on u.rid=r.rid WHERE u.uname=#{uname} and u.pwd=#{pwd} ")
    User login(User user);

    /**
     * 学生登陆的方法,根据用户id查询选课表.
     */
    @Select("SELECT * FROM `user` u LEFT JOIN role r \n" +
            "on u.rid=r.rid LEFT JOIN user_clazz uclazz\n" +
            "on uclazz.uid=u.uid LEFT JOIN clazz c ON\n" +
            "uclazz.cid=c.cid where u.uid=#{uid} ")
    List<User> stuList(User user);

    /**
     * 删除学生审核未通过的课程
     */
    @Delete("DELETE from user_clazz  where cid=#{cid}")
    void delstu(Clazz clazz);

    /**
     * 学生添加选课申请(获取所有未申请过的课程,以下拉框的形式展示)
     */
    @Select("select * from clazz where cid not in(SELECT c.cid from user_clazz uclazz LEFT JOIN\n" +
            "`user` u on uclazz.uid=u.uid LEFT JOIN\n" +
            " clazz c on c.cid=uclazz.cid WHERE u.uid=#{uid})")
    List<Clazz> addClazz(User user);

    /**
     * 学生添加选课申请(执行添加,向中间表里添加用户和课程)
     */
    @Insert("INSERT into user_clazz  set cid=#{c.cid},uid=#{u.uid},state=2")
    void addclazz(@Param("c") Clazz clazz, @Param("u") User user);

    /**
     * 查询审核通过的其它学生申请
     */
    @Select("SELECT * FROM user u LEFT JOIN user_clazz uclazz on u.uid=uclazz.uid\n" +
            "LEFT JOIN clazz c on c.cid=uclazz.cid where uclazz.state=1")
    List<User> AllPassApply(User user);

    /**
     * 管理员查询学生选课列表
     */
    @Select(" SELECT * FROM user u LEFT JOIN user_clazz uclazz on u.uid=uclazz.uid\n" +
            "LEFT JOIN clazz c on c.cid=uclazz.cid where uclazz.state in(1,2) ")
    List<User> stuAll(User user);

    /**
     * 管理员审核课程状态
     */
    @Update("update user_clazz set state=#{state} where cid=#{cid} and uid=#{uid}")
    void checkClazz(User user);


}
