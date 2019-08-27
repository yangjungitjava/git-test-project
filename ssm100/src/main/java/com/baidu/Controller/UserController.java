package com.baidu.Controller;

import com.baidu.Service.UserService;
import com.baidu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    @RequestMapping("login")
    public String registry(User user){

    }






}
