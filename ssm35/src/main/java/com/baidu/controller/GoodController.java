package com.baidu.controller;

import com.baidu.entity.Good;
import com.baidu.entity.User;
import com.baidu.service.IGoodService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class GoodController {
    @Autowired
    private IGoodService service;
    /**
     * 登录
     */
    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public User login(User user, HttpSession session){
        User u = service.login(user);
        if(u!=null){
            session.setAttribute("userinfo",u);
        }
        return u;
    }
    /**
     * 模糊加分页
     */
    @RequestMapping("list")
    public String list(Good good, Map<String,Object> map,String mohu,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size
                       ){
        mohu=mohu==null?"":mohu;
        PageInfo pageInfo = service.GoodList(mohu, page, size);
        map.put("mohu",mohu);
        map.put("pageInfo",pageInfo);
        return "list";
    }
    /**
     * 批量删除
     */
    @RequestMapping("plsc")
    public String plsc(@Param("ids") String ids){
        String[] split = ids.split("");
        service.plsc(split);
        return "redirect:list";
    }
    /**
     * 跳转添加页面
     */
    @RequestMapping("add")
    public String add(){
        return "add";
    }
    /**
     * 添加
     */
    @RequestMapping("toadd")
    public String toadd(Good good){
        service.add(good);
        return "redirect:list";
    }













































































}
