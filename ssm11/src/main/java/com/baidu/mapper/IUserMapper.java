package com.baidu.mapper;

import com.baidu.entity.Clazz;
import com.baidu.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IUserMapper {
    /**
     * 登陆
     */
    @Select("SELECT * FROM user u LEFT JOIN role r on u.role=r.rid WHERE u.uname=#{uname}\n" +
            "and u.pwd=#{pwd}  ")
    User login(User user);

    /**
     * 学生登陆进入选课列表
     */
    @Select("SELECT * from user u LEFT JOIN role r on u.role=r.rid\n" +
            "LEFT JOIN user_clazz uclazz on uclazz. uid=u.uid\n" +
            "LEFT JOIN clazz c on c.cid=uclazz.cid where u.role=1 and u.uid=#{uid}")
    List<User> stuList(User user);

    /**
     * 管理员登陆进入选课列表.需要判断role==2,controller进行判断.
     */
    @Select("SELECT * from user u LEFT JOIN user_clazz uclazz on u.uid=uclazz.uid\n" +
            "LEFT JOIN clazz c on c.cid=uclazz.cid where uclazz.state in(1,2)")
    List<User> stuAllList(User user);

    /**
     * 审核通过的其它学生的选课申请
     */
    @Select("SELECT *from user u LEFT JOIN user_clazz uclazz on u.uid=uclazz.uid\n" +
            "LEFT JOIN clazz c on c.cid=uclazz.cid where uclazz.state=1")
    List<User> otherstu(User user);

    /**
     * 删除审核未通过的申请记录
     */
    @Delete("DELETE FROM user_clazz  where cid=#{cid}")
    void delstu(Clazz clazz);

    /**
     * 学生添加选课申请记录(下拉框回显)
     */
    @Select("select * from clazz where cid not in(select c.cid from clazz c LEFT JOIN user_clazz uclazz on c.cid=uclazz.cid LEFT JOIN user u on u.uid=uclazz.uid where u.uid=1 )")
    List<Clazz> notchoose(User user);


}
