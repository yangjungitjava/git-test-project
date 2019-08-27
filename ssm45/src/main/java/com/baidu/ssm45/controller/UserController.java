package com.baidu.ssm45.controller;

import com.baidu.ssm45.pojo.Good;
import com.baidu.ssm45.pojo.User;
import com.baidu.ssm45.service.UserService;
import com.baidu.ssm45.utils.UploadAndDown;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String index(){
        return "login";
    }
    /**
     * 登录
     */
    @RequestMapping("login")
    @ResponseBody
    public User login(User user, HttpSession session){
        User u = userService.login(user);
        if(u!=null){
            session.setAttribute("userinfo",u);
        }
        return u;
    }
    /**
     * 列表
     */
    @RequestMapping("list")
    public String list(String mohu, @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map){
            mohu=mohu==null?"":mohu;
        PageInfo pageInfo = userService.ListGood(mohu, page, size);
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
        userService.plsc(split);
        return "redirect:list";
    }
    /**
     * 添加1
     */
    @RequestMapping("toaddpage")
    public String add1(Map<String,Object> map) throws IOException {
        List<Good> goods = userService.add1();
        map.put("list",goods);
        return "add";
    }


    @RequestMapping("add2")
    @ResponseBody
    public List<Good> add2(@RequestParam("cid") Integer cid) throws Exception {
        List<Good> add2 = userService.add2(cid);
        return add2;
    }

    @RequestMapping("insert")
    public String insert(Good good, MultipartFile multipartFile){
        //图片上传
        String upload = UploadAndDown.upload(multipartFile);
        //截图
        upload=upload.substring(upload.lastIndexOf("/")+1);
        //给图片赋值
        good.setImg(upload);
        userService.insert(good);
        return "redirect:list";
    }
}
