package com.baidu.controller;

import com.baidu.entity.Computer;
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
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    /**
     * 列表和模糊查询以及分页
     */
    @RequestMapping("list")
    public String list(String mohu,Map<String,Object> map,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size
                       ){
        mohu=mohu==null?"":mohu;
        PageInfo list = service.selectCom(mohu, page, size);
        map.put("mohu",mohu);
        map.put("pageInfo",list);
        return "list";
    }
    /**
     * 查询一级标题
     */
    @RequestMapping("selectOne")
    public String selectOne(Computer computer,Map<String,Object> map) throws IOException {
        List<Computer> computers = service.selectOne();
        map.put("list",computers);
        return "add";
    }
    /**
     * 查询二级标题
     */
    @RequestMapping("selectTwo")
    @ResponseBody
    public List<Computer> selectTwo(Integer oid) throws IOException {
        List<Computer> computers = service.selectTwo(oid);
        return computers;
    }



    /**
     * 添加或者修改以及头像的上传
     */
    @RequestMapping("insertComputer")
    public String insertComputer(Computer computer, MultipartFile multipartFile){
        //调用上传的工具类,返回值是一个路径.
        String upload = UploadAndDown.upload(multipartFile);
        System.out.print(upload);
        //static/c4bd3593-c456-4f59-8677-6ecd76772c0e.png
         upload = upload.substring(upload.lastIndexOf("/") + 1);//这一步不加图片出不来作为起始下标，截取起始坐标到字符串末尾间的字符，作为新的字符串。。。。
        computer.setImg(upload);
        service.editorComputer(computer);
        return "redirect:list";
    }
    /**
     * 修改回显
     */
    @RequestMapping("toupdateCom")
    public String toupdateCom(Integer cid,Map<String,Object> map) throws IOException {
        Computer selectCombyId = service.selectCombyId(cid);
        map.put("c",selectCombyId);
        //查询下拉框
        List<Computer> computers = service.selectOne();
        map.put("list",computers);
        return "add";
    }
    /**
     * 删除
     */
    @RequestMapping("delCom")
    public String delCom(Computer computer){
        service.delCom(computer);
        return "redirect:list";
    }
    /**
     * 登录
     */
    @RequestMapping("login")
    public String login(Computer computer, HttpSession session,Map<String,Object> map){
        Computer u = service.login(computer);
        if(u!=null){
            session.setAttribute("userinfo",u);
            return "redirect:list";
        }
        session.setAttribute("info","用户名或密码错误");
        return "login";
    }
    /**
     * 批量删除
     */
    @RequestMapping("plsc")
    public String plsc(@RequestParam("ids") String ids){//接受前台传来的一个ids
        String[] split = ids.split("");
        service.plsc(split);
        return "redirect:list";
    }













































}
