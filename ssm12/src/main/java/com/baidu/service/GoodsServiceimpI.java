package com.baidu.service;

import com.baidu.entity.Goods;
import com.baidu.mapper.IGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceimpI implements IGoodsService {
    @Autowired
    private IGoodsMapper mapper;

    @Override
    public List<Goods> selectGoods(String mohu) {
        return mapper.selectGoods(mohu);
    }

    @Override
    public void add(Goods goods) {
        mapper.add(goods);
    }

    @Override
    public void del(Goods goods) {
        mapper.del(goods);
    }

    @Override
    public Goods selectGoodsById(Goods goods) {
        return mapper.selectGoodsById(goods);
    }

    @Override
    public void update(Goods goods) {
        mapper.update(goods);
    }
}
