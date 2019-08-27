package com.baidu.controller;

import com.baidu.entity.Good;
import com.baidu.entity.User;
import com.baidu.service.IGoodService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class GoodController {
    @Autowired
    private IGoodService service;
    /**
     * 登录
     */
    @RequestMapping("login")
    public String login(User user, HttpSession session, Map<String,Object> map){
        User u = service.login(user);
        if(u!=null){
            //存入session
            session.setAttribute("userinfo",u);
            if (u.getRid()==1){
                return Allgoods(user, session, map);
            }
            return goodList(user,null,1,2,session,map);//这个地方要打出模糊:null直接打null才能出来.
        }
            session.setAttribute("info","用户名密码错误");
            return "login";
    }
    /**
     * 用户登录列表,用户：列表展示全部商品.
     */
    @RequestMapping("Allgoods")
    public String Allgoods(User user,HttpSession session,Map<String,Object> map){
        List<Good> allgoods = service.Allgoods(user);
        User u= (User) session.getAttribute("userinfo");
        map.put("list",allgoods);
        return "Allgoods";
    }
    /**
     * 我购买的商品“列表
     */
    @RequestMapping("MyGood")
    public String MyGood( User user,Map<String,Object> map,Good good,HttpSession session){
        List<Good> myGoodById = service.MyGoodById(user);
        session.getAttribute("userinfo");
        map.put("list",myGoodById);
        return "MyGood";
    }
    /**
     * 购买商品后，将商品添加到我的商品列表中
     */
    @RequestMapping("addGood")
    public  String addGood(Good good,HttpSession session){
        session.getAttribute("userinfo");
        service.addGood(good);
        return "MyGood";
    }
    /**
     * 商家：列表展示自己发布的商品列表模糊分页
     */
    @RequestMapping("goodList")
    public String goodList(User user,String mohu,
                           @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                           @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                           HttpSession session,Map<String,Object> map){
          User u= (User) session.getAttribute("userinfo");
            //模糊非空判断
            mohu=mohu==null?"":mohu;
            PageInfo pageInfo = service.GoodList(u, mohu, page, size);
            map.put("pageInfo",pageInfo);
            map.put("mohu",mohu);
        return "goodList";
    }
    /**
     * 查询下拉框
     */
    @RequestMapping("SelectGoods")
    public String SelectGoods(Good good,Map<String,Object> map){
        List<Good> selectType = service.selectType();
        map.put("list",selectType);
        return "insertGoods";
    }

    /**
     * 商家发布商品（10分
     */
    @RequestMapping("insertGoods")
    public String insertGoods(User user, HttpSession session ){
         session.getAttribute("userinfo");
        service.insertGoods(user);
        return "redirect:goodList";
    }





































    /**
     * 修改回显
     */
    @RequestMapping("update")
    public String update(Good good,Map<String,Object> map){
        Good updateById = service.updateById(good);
        map.put("c",updateById);
        return "update";
    }
    /**
     * 7.商品修改功能（10分）
     */
    @RequestMapping("updategood")
    public String updategood(User user){
        service.updategood(user);
        return "redirect:Allgoods";
    }





















































































































}
