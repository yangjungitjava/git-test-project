package com.baidu.service;

import com.baidu.entity.Clazz;
import com.baidu.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserService {
    /**
     * 登陆
     */
    User login(User user);

    /**
     * 学生登陆进入选课列表
     */
    List<User> stuList(User user);

    /**
     * 管理员登陆进入选课列表.需要判断role==2,controller进行判断.
     */
    List<User> stuAllList(User user);

    /**
     * 审核通过的其它学生的选课申请
     */
    List<User> otherstu(User user);

    /**
     * 删除审核未通过的申请记录
     */
    void delstu(Clazz clazz);

    /**
     * 学生添加选课申请记录(下拉框回显)
     */
    List<Clazz> notchoose(User user);


}
