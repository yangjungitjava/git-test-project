package com.baidu.contrller;

import com.baidu.entity.Goods;
import com.baidu.service.IGoodsService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private IGoodsService service;

    /**
     * 列表模糊
     */
    @RequestMapping("list")
    public String list(String mohu, Model model) {
        List<Goods> goodsList = service.selectGoods(mohu);
        model.addAttribute("mohu", mohu);
        model.addAttribute("list", goodsList);
        return "list";
    }

    /**
     * 跳转添加页面
     */
    @RequestMapping("add")
    public String add() {
        return "add";
    }

    /**
     * 添加
     */
    @RequestMapping("toadd")
    public String add(Goods goods) {
        service.add(goods);
        return "redirect:list";
    }

    /**
     * 删除
     */
    @RequestMapping("del")
    public String del(Goods goods) {
        service.del(goods);
        return "redirect:list";
    }

    /**
     * 修改回显
     */
    @RequestMapping("update")
    public String update(Goods goods, Model model) {
        Goods selectGoodsById = service.selectGoodsById(goods);
        model.addAttribute("g", selectGoodsById);
        return "update";
    }

    /**
     * 修改
     */
    @RequestMapping("toupdate")
    public String toupdate(Goods goods) {
        service.update(goods);
        return "redirect:list";
    }


}
