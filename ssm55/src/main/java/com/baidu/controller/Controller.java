package com.baidu.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String list(){
        return "list";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("add")
    public String add(){
        return "add";
    }
}
