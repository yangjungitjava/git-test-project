package com.baidu.service;

import com.baidu.entity.Product;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductService {
    /**
     * 列表分页
     */
    PageInfo selectList(Integer  page, Integer size);
    /**
     * 批量删除
     */
    void plsc(String split[]);
    /**
     * 获取颜色单选按钮
     */
    List<Product> selectcolor();
















}
