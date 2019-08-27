package com.baidu.service;

import com.baidu.entity.Computer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.IOException;
import java.util.List;

public interface IComputerService {
    /**
     * 列表
     */
    List<Computer> selectlist(String name);

    /**
     * 一级标题(以下拉框的形式展示)
     */
    List<Computer> selectOne() throws IOException;

    /**
     * 二级标题(以下拉框的形式展示,通过一级标题给出的oid来获得tid,然后以 下拉框的形式展示出来)
     */
    List<Computer> selectTwo(Integer oid) throws IOException;

    /**
     * 修改回显
     */
    Computer selectListById(Computer computer);

    /**
     * 修改或添加
     */
    void editorCom(Computer computer);

    /**
     * 登陆
     */
    Computer login(Computer computer);


}
