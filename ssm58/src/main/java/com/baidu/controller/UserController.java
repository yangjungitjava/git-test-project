package com.baidu.controller;

import com.baidu.pojo.Product;
import com.baidu.service.IUserService;
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
    private IUserService iUserService;
    @RequestMapping("login")
    public String login(Product product, HttpSession session, Map<String,Object>map){
        Product u = iUserService.Login(product);
        if(u!=null){
            session.setAttribute("userinfo",u);
            return "redirect:list";
        }
        session.setAttribute("info","用户名或密码错误");
        return "login";
    }
    @RequestMapping("unique")
    @ResponseBody
    public Boolean unique(Product product){
        int i = iUserService.unique(product);
        return i>0;
    }
    @RequestMapping("list")
    public String list(Map<String,Object> map,HttpSession session){
        List<Product> products = iUserService.selectList();
        map.put("list",products);
        session.setAttribute("Product",products);
        return "list";
    }
    @RequestMapping("selectType")
    public String selectType(Map<String,Object> map){
        List<Product> products = iUserService.selectType();
        map.put("list",products);
        return "add";
    }
    @RequestMapping("toadd")
    public String toadd(Product product){
        iUserService.add(product);
        return "redirect:list";
    }
    @RequestMapping("order")
    public String insert(HttpSession session){
        Product product= (Product) session.getAttribute("Product");
        Integer id = product.getId();

        iUserService.insert(product);
        return "insert";
    }
}
