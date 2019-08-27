package com.baidu.controller;

import com.baidu.pojo.Goods;
import com.baidu.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService service;
    /**
     * 列表
     */
    @RequestMapping("list")
    public String list(String mohu,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map ,  Double begin , Double end ){
        mohu=mohu==null?"":mohu;
        if(begin == null){
            begin = 0.0;
        }
        if(end == null){
            end = 9999999999.0;
        }
        PageInfo pageInfo = service.GoodsList(mohu, page, size,begin,end);
        map.put("mohu",mohu);
        map.put("pageInfo",pageInfo);
        map.put("begin",begin);
        map.put("end",end);
        return "list";
    }
    /**
     * 删除
     */
    @RequestMapping("plsc")
    public String plsc(@RequestParam("ids") String ids){
        String[] split = ids.split("");
        service.plsc(split);
        return "redirect:list";
    }
    /**
     * 查询品牌
     */
    @RequestMapping("selectOne")
    public String selectOne(Map<String,Object> map){
        List<Goods> selectOne = service.selectOne();
        map.put("list",selectOne);
        return "add";
    }
    /**
     * 查询类型
     */
    @RequestMapping("selectTwo")
    @ResponseBody
    public List<Goods> selectTwo(@RequestParam("cid") Integer cid){
        List<Goods> selectTwo = service.selectTwo(cid);
        return selectTwo;
    }
    /**
     * 添加
     */
    @RequestMapping("add")
    public String add(Goods goods){
        service.editor(goods);
        return "redirect:list";
    }
    /**
     * 修改回显
     */
    @RequestMapping("selectbyid")
    public String selectbyid(Goods goods,Map<String,Object> map){
        Goods selectbyid = service.selectbyid(goods);
        List<Goods> selectOne = service.selectOne();
        map.put("s",selectbyid);
        map.put("list",selectOne);
        return "add";
    }

}
