package com.baidu.controller;

import com.baidu.entity.Good;
import com.baidu.entity.Type;
import com.baidu.service.IGoodService;
import com.baidu.utils.UploadAndDown;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class GoodController {
    @Autowired
    private IGoodService service;
    /**
     * 列表模糊分页
     */
    @RequestMapping("list")
    public String list(String name,
                       @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                       @RequestParam(value = "size",required = false,defaultValue = "2")Integer size,
                       Map<String,Object> map
                       ){
        name=name==null?"":name;
        PageInfo pageInfo = service.GoodList(name,  page, size);
        map.put("name",name);
        map.put("pageInfo",pageInfo);
        return "list";
    }
    /**
     * 批量删除
     */
    @RequestMapping("plsc")
    public void plsc( String ids){
        service.plsc(ids);
    }
    /**
     * 跳转添加页面
     *
     */
    @RequestMapping("add")
    public String add(){
        return "add";
    }

    /**
     * 查询下拉框
     */
    @RequestMapping("xl")
    @ResponseBody
    public List<Type> xl(){
        List<Type> typeList = service.selectType();
       return typeList;
    }
    /**
     * 添加
     */
    @RequestMapping("insert")
    public String insert(Good good,  MultipartFile multipartFile){
        String upload = UploadAndDown.upload(multipartFile);
      //  upload = upload.substring(upload.lastIndexOf("/" + 1));
        upload = upload.substring(upload.lastIndexOf("/") + 1);
        good.setImg(upload);
        service.add(good);
        return "redirect:list";
    }









































































}
