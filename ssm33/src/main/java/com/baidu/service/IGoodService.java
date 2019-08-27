package com.baidu.service;

import com.baidu.entity.Good;
import com.baidu.entity.Type;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGoodService {
    /**
     * 列表模糊分页
     */
    PageInfo GoodList(String name, Integer page, Integer size);
    /**
     * 批量删除
     */
    void plsc( String ids);
    /**
     * 查询下拉框
     */
    List<Type> selectType();
    /**
     * 添加
     */
    void add(Good good);






























































}
