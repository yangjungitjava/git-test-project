package com.baidu.service;

import com.baidu.entity.Computer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.io.IOException;
import java.util.List;

public interface UserService {
    /**
     * 列表和模糊查询
     */
    PageInfo selectCom(String mohu, Integer page, Integer size);
    /**
     * 查询一级标题
     */
    List<Computer> selectOne() throws IOException;
    /**
     * 查询二级标题
     */
    List<Computer> selectTwo(Integer oid) throws IOException;
    /**
     * 修改或者添加
     */
    void editorComputer(Computer computer);
    /**
     * 修改回显
     */
    Computer selectCombyId(Integer cid);
    /**
     * 删除
     */
    void delCom(Computer computer);
    /**
     * 登录
     */
    Computer login(Computer computer);
    /**
     * 批量删除
     */
    void plsc(String[] split);











































































}
