package com.baidu.controller;

import com.baidu.pojo.Good;
import com.baidu.pojo.User;
import com.baidu.service.UserService;
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
    private UserService userService;
    /**
     * 登录
     */
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    @RequestMapping("login")
    @ResponseBody
    public User login(HttpSession session, Map<String,Object> map,User user){
        User u = userService.login(user);
        if(u!=null){
            session.setAttribute("userinfo",u);
        }
        return u;
    }
    /**
     * 列表页面
     */
    @RequestMapping("list")
    public String list(String mohu,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map ){
        //模糊非空判断
        mohu=mohu==null?"":mohu;
        PageInfo pageInfo = userService.goodList(mohu, page, size);
        map.put("pageInfo",pageInfo);
        map.put("mohu",mohu);
        return "list";
    }
    /**
     * 历史记录
     */
    @RequestMapping("historyDate")
    public String historyDate(Good good,Map<String,Object> map,HttpSession session){
        List<Good> histoty = userService.histoty();
        session.getAttribute("userinfo");
        map.put("list",histoty);
        return "historyDate";
    }
    /**
     * 添加
     */
    @RequestMapping("toadd")
    public String toadd(){
        return "add";
    }
    @RequestMapping("add")
    public String add(Good good){
        userService.editor(good);
        return "redirect:list";
    }
    /**
     * 修改回显
     */
    @RequestMapping("selectGoodById")
    public String selectGoodById(Good good,Map<String,Object> map ){
        Good selectGoodById = userService.selectGoodById(good);
        map.put("u",selectGoodById);
        return "add";
    }
}
