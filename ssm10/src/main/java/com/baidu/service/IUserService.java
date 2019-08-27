package com.baidu.service;

import com.baidu.entity.Clazz;
import com.baidu.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserService {
    /**
     * 登陆
     */
    User login(User user);

    /**
     * 学生登陆的方法,根据用户id查询选课表.
     */
    List<User> stuList(User user);

    /**
     * 删除学生审核未通过的课程
     */
    void delstu(Clazz clazz);

    /**
     * 学生添加选课申请(获取所有未申请过的课程,以下拉框的形式展示)
     */
    List<Clazz> addClazz(User user);

    /**
     * 学生添加选课申请(执行添加,向中间表里添加用户和课程)
     */
    void addclazz(Clazz clazz, User user);

    /**
     * 查询审核通过的其它学生申请
     */
    List<User> AllPassApply(User user);

    /**
     * 管理员查询学生选课列表
     */
    List<User> stuAll(User user);

    /**
     * 管理员审核课程状态
     */
    void checkClazz(User user);


}
