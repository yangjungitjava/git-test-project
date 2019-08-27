package com.baidu.controller;

import com.baidu.entity.Computer;
import com.baidu.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ComputerController {
    @Autowired
    private IComputerService service;

    /**
     * 列表
     */
    @RequestMapping("list")
    public String list(Model model, String name) {
        name = name == null ? "" : name;
        List<Computer> computerList = service.selectlist(name);
        model.addAttribute("list", computerList);
        model.addAttribute("name", name);
        return "list";
    }

    /**
     * 一级标题(以下拉框的形式展示)
     */
    @RequestMapping("add")
    public String selectOne(Model model) throws IOException {
        List<Computer> selectOne = service.selectOne();
        model.addAttribute("list", selectOne);
        return "add";
    }

    /**
     * 二级标题(以下拉框的形式展示,通过一级标题给出的oid来获得tid,然后以 下拉框的形式展示出来)
     */
    @RequestMapping("gettid")
    @ResponseBody
    public List<Computer> selectTwo(Integer oid) throws IOException {
        List<Computer> selectTwo = service.selectTwo(oid);
        return selectTwo;
    }

    /**
     * 添加或修改
     */
    @RequestMapping("toadd")
    public String editorCom(Computer computer) {
        service.editorCom(computer);
        return "redirect:list";
    }

    /**
     * 修改回显
     */
    @RequestMapping("editor")
    public String toupdate(Computer computer, Model model) throws IOException {
        Computer selectListById = service.selectListById(computer);
        model.addAttribute("c", selectListById);
        //查询下拉框
        List<Computer> list = service.selectOne();
        model.addAttribute("list", list);
        return "add";
    }

    /**
     * 登陆
     */
    @RequestMapping("login")
    public String login(Computer computer, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (computer.getName() != null) {
            Computer u = service.login(computer);
            if (u != null) {
                session.setAttribute("userinfo", u);
                return "redirect:list";
            } else {
                session.setAttribute("info", "用户名不存在");
                return "login";
            }
        } else {
            session.setAttribute("info", "请输入用户名");
            return "login";
        }

    }


}
