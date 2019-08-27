package com.baidu.controller;

import com.baidu.entity.Product;
import com.baidu.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private IProductService service;
    /**
     * 列表分页
     */
    @RequestMapping("list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map
                       ){
        PageInfo pageInfo = service.selectList(page, size);
        map.put("pageInfo",pageInfo);
        return "list";
    }
    /**
     * 批量删除
     */
    @RequestMapping("plsc")
    public String plsc(@RequestParam("ids") String ids){
        String[] split = ids.split("");
        service.plsc(split);
        return "redirect:list";
    }
    /**
     * 获取颜色单选按钮
     */
    @RequestMapping("selectcolor")
    public String selectcolor(Map<String,Object> map){
        List<Product> list = service.selectcolor();
        map.put("list",list);
        return "add";
    }






























































































































}
