package com.baidu.ssm45.service;
import com.baidu.ssm45.pojo.Good;
import com.baidu.ssm45.pojo.User;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;


public interface UserService {
    /**
     * 登录
     */
    User login(User user);
    /**
     * 列表
     */
    PageInfo ListGood(String mohu, Integer page, Integer size);

    /**
     * 批量删除
     * @param split
     */
    void plsc(String[] split);
    /**
     * 添加1
     */
    List<Good> add1() throws IOException;

    List<Good>add2(Integer cid) throws Exception;

    void insert(Good good);

}
