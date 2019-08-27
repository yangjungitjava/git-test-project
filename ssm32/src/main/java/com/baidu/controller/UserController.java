package com.baidu.controller;

import com.baidu.entity.Order;
import com.baidu.entity.User;
import com.baidu.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private IUserService service;
    @RequestMapping("/")
    public String fhh(){
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public User login(User user, HttpSession session){
        User u = service.login(user);
        if (u!=null){
            session.setAttribute("userinfo",u);
        }
        return u;
    }
    @RequestMapping("list")
    public String list(Map<String,Object> map, String mohu,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "3")Integer size
                       ){
        mohu=mohu==null?"":mohu;
        PageInfo pageInfo = service.selectOrder(mohu, page, size);
        map.put("pageInfo",pageInfo);
        map.put("mohu",mohu);
        return "list";
    }
    @RequestMapping("plsc")
    @ResponseBody
    public void plsc(@RequestParam("ids") String ids){
        String[] split = ids.split("");
        service.plsc(split);
    }
    @RequestMapping("xl")
    public String xl(Order order,Map<String,Object> map){
        List<Order> selectType = service.selectType();
        map.put("list",selectType);
        return "add";
    }

    @RequestMapping("insertOrder")
    public String insertOrder(Order order){
        service.addOrder(order);
        return "redirect:list";
    }
















}
