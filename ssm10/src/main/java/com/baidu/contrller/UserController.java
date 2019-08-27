package com.baidu.contrller;

import com.baidu.entity.Clazz;
import com.baidu.entity.User;
import com.baidu.service.IUserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        //获取session
        HttpSession session = request.getSession();
        //调用service层的登陆的方法
        User u = service.login(user);
        if (u != null) {
            if (u.getRid() == 1) {
                //调用service层的学生登陆的方法,根据用户id查询选课表.
                List<User> stuList = service.stuList(u);
                request.setAttribute("list", stuList);
                session.setAttribute("userinfo", u);
                return "stuList";
            } else if (u.getRid() == 2) {
                //调用service层的管理员查询选课列表的方法,根据审核状态查询.
                List<User> stuAll = service.stuAll(u);
                request.setAttribute("list", stuAll);
                session.setAttribute("userinfo", u);
                return "stuAll";
            }
        }
        session.setAttribute("info", "用户名或密码错误");
        return "login";

    }

    /**
     * 删除学生审核未通过的课程
     */
    @RequestMapping("delstu")
    @ResponseBody
    public void delstu(Clazz clazz) {
        service.delstu(clazz);
    }

    /**
     * 学生添加选课申请(获取所有未申请过的课程,以下拉框的形式展示)
     */
    @RequestMapping("addClazz")
    public String addClazz(HttpSession session, Model model) {
        //把学生从session中获取出来
        User us = (User) session.getAttribute("userinfo");
        List<Clazz> clazzes = service.addClazz(us);
        model.addAttribute("list", clazzes);
        model.addAttribute("us", us);
        return "addClazz";
    }

    /**
     * 学生添加选课申请(执行添加,向中间表里添加用户和课程)
     */
    @RequestMapping("addclazz")
    @ResponseBody
    public void addclazz(Clazz clazz, User user) {
        service.addclazz(clazz, user);
    }

    /**
     * 查询审核通过的其它学生申请
     */
    @RequestMapping("AllPassApply")
    public String AllPassApply(User user, Model model) {
        List<User> allPassApply = service.AllPassApply(user);
        model.addAttribute("list", allPassApply);
        return "AllPassApply";
    }

    /**
     * 管理员审核课程状态
     */
    @RequestMapping("checkClazz")
    @ResponseBody
    public void checkClazz(User user) {
        service.checkClazz(user);
    }


}
