package com.baidu.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String index(){
        return "list";
    }
}
