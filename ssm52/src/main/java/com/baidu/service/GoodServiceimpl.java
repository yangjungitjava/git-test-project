package com.baidu.service;

import com.baidu.mapper.GoodMapper;
import com.baidu.pojo.Good;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceimpl implements GoodService{
    @Autowired
    private GoodMapper mapper;
    /**
     * 列表
     */
    @Override
    public PageInfo selectList(Integer page, Integer size, String gname,String gid) {
        PageHelper.startPage(page,size);
        List<Good> goods = mapper.selectList(gname,gid);
        PageInfo<Good> pageInfo = new PageInfo<>(goods);
        return pageInfo;
    }
    /**
     * 价格调整回显
     */
    @Override
    public Good selectById(Good good) {
        return mapper.selectById(good);
    }
    /**
     * 价格调整
     */
    @Override
    public void update(Good good) {
        mapper.update(good);
    }
    /**
     * 仅显示有货
     */
    @Override
    public List<Good> youhuo() {
        return mapper.youhuo();
    }
}
