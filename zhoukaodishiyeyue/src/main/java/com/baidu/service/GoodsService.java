package com.baidu.service;

import com.baidu.pojo.Goods;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsService {
    /**
     * 列表
     */
    PageInfo GoodsList(String mohu,Integer page,Integer size, double begin , double end);
    /**
     * 删除
     */
    void plsc( String split[]);
    /**
     * 查询品牌
     */
    List<Goods> selectOne();
    /**
     * 查询类型
     */
    List<Goods> selectTwo( Integer cid);
    /**
     * 添加或者修改
     */
    void editor(Goods goods);
    /**
     * 修改回显
     */
    Goods selectbyid(Goods goods);
}
