package com.baidu.service;

import com.baidu.pojo.Good;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodService {
    /**
     * 列表
     */
     PageInfo selectList(Integer page, Integer size, String gname,String gid);
    /**
     * 价格调整
     */
    Good selectById(Good good);
    /**
     * 价格调整
     */
    void update(Good good);
    /**
     * 仅显示有货
     */
    List<Good> youhuo();
}
