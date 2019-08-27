package com.baidu.service;

import com.baidu.entity.Huiyi;
import com.baidu.entity.Type;
import com.baidu.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HuiyiService {
    /**
     * 登录
     */
    User login(User user);
    /**
     * 列表
     */
   PageInfo List( String mohu,Integer page, Integer size);
    /**
     * 下拉
     */
    List<Type> xl();
    /**
     * 添加
     */
    void add(Huiyi huiyi);
}
