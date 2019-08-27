package com.baidu.service;

import com.baidu.entity.Good;
import com.baidu.entity.Type;
import com.baidu.mapper.IGoodMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodServiceimpI implements IGoodService{
    @Autowired
    private IGoodMapper mapper;
    /**
     * 列表模糊分页
     */
    @Override
    public PageInfo GoodList(String name,  Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Good> goodList = mapper.GoodList(name);
        PageInfo<Good> pageInfo = new PageInfo<>(goodList);
        return pageInfo;
    }
    /**
     * 批量删除
     */
    @Override
    public void plsc(String ids) {
            mapper.plsc(ids);

    }
    /**
     * 查询下拉框
     */
    @Override
    public List<Type> selectType() {
        return mapper.selectType();
    }
    /**
     * 添加
     */
    @Override
    public void add(Good good) {
        mapper.add(good);
    }


}
