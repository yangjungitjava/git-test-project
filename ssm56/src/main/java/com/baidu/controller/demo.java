package com.baidu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class demo {
    @RequestMapping("/")
    public String index(){
        return "list";
    }
}
