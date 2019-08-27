package com.baidu.service;

import com.baidu.mapper.GoodsMapper;
import com.baidu.pojo.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceimpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public PageInfo GoodsList(String mohu, Integer page, Integer size, double begin , double end) {
        PageHelper.startPage(page,size);
        List<Goods> goodsList = goodsMapper.GoodsList(mohu,begin,end);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }

    @Override
    public void plsc(String[] split) {
        for (String s : split) {
            goodsMapper.plsc(s);
        }
    }

    @Override
    public List<Goods> selectOne() {
        return goodsMapper.selectOne();
    }

    @Override
    public List<Goods> selectTwo(Integer cid) {
        return goodsMapper.selectTwo(cid);
    }

    @Override
    public void editor(Goods goods) {
        if(goods.getId()!=null){
            goodsMapper.update(goods);
        }else{
            goodsMapper.add(goods);
        }
    }


    @Override
    public Goods selectbyid(Goods goods) {
        return goodsMapper.selectbyid(goods);
    }
}
