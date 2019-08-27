package com.baidu.controller;

import com.baidu.entity.Huiyi;
import com.baidu.entity.Type;
import com.baidu.entity.User;
import com.baidu.service.HuiyiService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.SunHints;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class HuiyiController {
    @Autowired
    private HuiyiService service;

    /**
     * 登录
     */
    @RequestMapping("login")
    public String login(User user, HttpSession session, Map<String,Object> map){
        User u = service.login(user);
        if(u!=null){
            session.setAttribute("userinfo",u);
            return "redirect:list";
        }
        session.setAttribute("info","用户名或密码错误");
        return "login";
    }
    /**
     * 列表
     */
    @RequestMapping("list")
    public String list(String mohu,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map
                       ){
        mohu=mohu==null?"":mohu;
        PageInfo pageInfo = service.List(mohu, page, size);
        map.put("pageInfo",pageInfo);
        map.put("mohu",mohu);
        return "list";
    }
    /**
     * 跳转添加页面
     */
    @RequestMapping("xl")
    public String add(){
        return "add";
    }

    /**
     * 下拉
     */
    @RequestMapping("selectxl")
    @ResponseBody
    public List<Type> selectxl(){
        List<Type> xl = service.xl();
        return xl;
    }
    /**
     * 添加
     */
    @RequestMapping("inserthuiyi")
    public String inserthuiyi(Huiyi huiyi){
        service.add(huiyi);
        return "redirect:list";
    }
}
