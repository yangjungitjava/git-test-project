package com.baidu.controller;

import com.baidu.entity.Clazz;
import com.baidu.entity.User;
import com.baidu.service.IUserService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService service;

    /**
     * 登陆
     */
    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User u = service.login(user);
        if (u != null) {
            if (u.getRole() == 1) {
                List<User> stuList = service.stuList(u);
                session.setAttribute("userinfo", u);
                request.setAttribute("list", stuList);
                return "stuList";
            } else if (u.getRole() == 2) {
                List<User> stuAllList = service.stuAllList(u);
                session.setAttribute("userinfo", u);
                request.setAttribute("list", stuAllList);
                return "stuAllList";
            }

        }
        session.setAttribute("info", "用户名或密码错误");
        return "login";
    }

    /**
     * 审核通过的其它学生的选课申请
     */
    @RequestMapping("otherstu")
    public String otherstu(User user, HttpServletRequest request) {
        List<User> otherstu = service.otherstu(user);
        request.setAttribute("list", otherstu);
        return "otherstu";
    }

    /**
     * 删除审核未通过的申请记录
     */
    @RequestMapping("delstu")
    @ResponseBody
    public void delstu(Clazz clazz) {
        service.delstu(clazz);
    }

    /**
     * 学生添加选课申请记录(下拉框回显)
     */
    @RequestMapping("addclazz")
    public String notchoose(User user, HttpServletRequest request) {
        List<Clazz> notchoose = service.notchoose(user);
        request.setAttribute("list", notchoose);
        return "addclazz";
    }


}
