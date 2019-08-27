package com.baidu.controller;

import com.baidu.pojo.Good;
import com.baidu.service.GoodService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GoodController {
    @Autowired
    private GoodService service;
    /**
     * 列表
     */
    @RequestMapping("list")
    public String list(String mohu,String gid,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map){
        mohu=mohu==null?"":mohu;
        gid=gid==null?"":gid;
        PageInfo pageInfo = service.selectList(page, size, mohu,gid);
        map.put("mohu",mohu);
        map.put("gid",gid);
        map.put("pageInfo",pageInfo);
        return "list";
    }
    /**
     * 价格调整回显
     */
    @RequestMapping("selectById")
    public String selectById(Good good, Map<String,Object> map){
        Good selectById = service.selectById(good);
        map.put("g",selectById);
        return "update";
    }
    /**
     * 价格调整
     */
    @RequestMapping("updateGood")
    @ResponseBody
    public void updateGood(Good good){
        service.update(good);
    }
    /**
     * 仅显示有货
     */
    @RequestMapping("youhuo")
    public String youhuo(Map<String,Object> map){
        List<Good> youhuo = service.youhuo();
        map.put("g",youhuo);
        return "list";
    }

}
