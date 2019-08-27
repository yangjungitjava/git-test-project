package com.baidu.service;

import com.baidu.entity.Huiyi;
import com.baidu.entity.Type;
import com.baidu.entity.User;
import com.baidu.mapper.HuiyiMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuiyiServiceimpI implements HuiyiService{
    @Autowired
    private HuiyiMapper mapper;
    /**
     * 登录
     */
    @Override
    public User login(User user) {
        return mapper.login(user);
    }
    /**
     * 列表
     */
    @Override
    public PageInfo List( String mohu,Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Huiyi> list = mapper.List(mohu);
        PageInfo<Huiyi> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    /**
     * 下拉
     */
    @Override
    public List<Type> xl() {
        return mapper.xl();
    }
    /**
     * 添加
     */
    @Override
    public void add(Huiyi huiyi) {
        mapper.add(huiyi);
    }

}
