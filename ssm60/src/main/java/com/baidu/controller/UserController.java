package com.baidu.controller;

import com.baidu.Service.UserService;
import com.baidu.pojo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;
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
     * 列表
     */
    @RequestMapping("list")
    public String list(Map<String,Object>map, String mohu,
                       @RequestParam(value = "page",defaultValue = "1",required = false)Integer page,
                       @RequestParam(value = "size",defaultValue = "2",required = false)Integer size){
        mohu=mohu==null?"":mohu;
        PageInfo pageInfo = service.list(page, size, mohu);
        map.put("mohu",mohu);
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
     * 跳转添加页面
     */
    @RequestMapping("toadd")
    public String toadd(){
        return "add";
    }
    /**
     * 新建或者修改
     */
    @RequestMapping("insert")
    public String insert(User user){
        service.editor(user);
        return "redirect:list";
    }
    /**
     * 修改回显
     */
    @RequestMapping("selectById")
    public String selectById(User user,Map<String,Object>map){
        User selectById = service.selectById(user);
        map.put("l",selectById);
        return "add";
    }
    /**
     * 开启
     */
    @RequestMapping("kaiqi")
    public String kaiqi(User user){
        service.kaiqi(user);
        return "redirect:list";
    }
    /**
     * 屏蔽
     */
    @RequestMapping("pinbi")
    public String pinbi(User user){
        service.pinbi(user);
        return "redirect:list";
    }


}
