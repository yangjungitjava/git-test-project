package com.baidu.service;

import com.baidu.pojo.Information;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    PageInfo Information(String mohu, Integer page, Integer size, String time);

    Information selectById(Long id);

    Information login(Information information);

    void add(Information information);

    List<Information> selectByType();

    int unique(Information information);

    void updateUser(Information information);

    void plsc( String split[]);
}
