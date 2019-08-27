package com.baidu.controller;

import com.baidu.pojo.Information;
import com.baidu.service.UserService;
import com.baidu.utils.UploadAndDown;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("list")
    public String list(String mohu,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map  ,  String time){
        mohu=mohu==null?"":mohu;

        PageInfo pageInfo = userService.Information(mohu, page, size,time);
        map.put("mohu",mohu);
        map.put("pageInfo",pageInfo);
        map.put("time",time);
        return "list";
    }
    @RequestMapping("selectById")
    public String selectById(Map<String,Object> map,@RequestParam("id") Long id){
        Information selectById = userService.selectById(id);
        map.put("i",selectById);
        return "update";
    }
    @RequestMapping("login")
    public String login(Information information, Map<String,Object> map, HttpSession session){
        Information u = userService.login(information);
        if(u!=null){
                session.setAttribute("userinfo",u);
                return "redirect:list";
        }
        session.setAttribute("info","用户名或密码错误");
        return "login";
    }
    @RequestMapping("selectType")
    public String selectType(Map<String,Object> map){
        List<Information> informationList = userService.selectByType();
        map.put("list",informationList);
        return "add";
    }
    @RequestMapping("toadd")
    public String add(Information information,MultipartFile multipartFile ){
        String upload = UploadAndDown.upload(multipartFile);
        upload=upload.substring(upload.lastIndexOf("/")+1);
        information.setImg(upload);
        userService.add(information);
        return "redirect:list";
    }
    @RequestMapping("unique")
    @ResponseBody
    public Boolean unique(Information information){
        int i = userService.unique(information);
        return i>0;
    }
    @RequestMapping("updateUser")
    public String updateUser(Information information){
        userService.updateUser(information);
        return "redirect:list";
    }
    @RequestMapping("plsc")
    public String plsc(@RequestParam("ids") String ids){
        String[] split = ids.split("");
        userService.plsc(split);
        return "redirect:list";
    }
}
