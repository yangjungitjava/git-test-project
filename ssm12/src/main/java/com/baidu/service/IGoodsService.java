package com.baidu.service;

import com.baidu.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsService {
    /**
     * 列表模糊
     */
    List<Goods> selectGoods(@Param("mohu") String mohu);

    /**
     * 添加
     */
    void add(Goods goods);

    /**
     * 删除
     */
    void del(Goods goods);

    /**
     * 修改回显
     */
    Goods selectGoodsById(Goods goods);

    /**
     * 修改
     */
    void update(Goods goods);


}
