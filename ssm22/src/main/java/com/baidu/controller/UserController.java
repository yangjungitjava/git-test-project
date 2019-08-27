package com.baidu.controller;

import com.baidu.entity.User;
import com.baidu.entity.User_goods;
import com.baidu.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService service;

    /**
     * 登陆
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(User user, HttpServletRequest request) {
        User u = service.login(user);
        HttpSession session = request.getSession();
        if (u != null) {
            if (u.getRid() == 1) {
                /*菜品名称使用下拉框实现，需要从数据库中查出*/
                List<User_goods> user_goods = service.selectGoods();
                request.setAttribute("list", user_goods);
                session.setAttribute("userinfo", u);
                return "userList";
            } else if (u.getRid() == 2) {
                /**
                 * 快递员角色：查看所有用户发布的订单
                 */
                List<User_goods> goodsAll = service.GoodsAll();
                request.setAttribute("list", goodsAll);
                session.setAttribute("userinfo", u);
                return "GoodsAll";
            }

        }
        session.setAttribute("info", "用户名或密码错误");
        return "login";
    }

    /**
     * 发布订单功能
     */
    @RequestMapping("userList")
    public String userList(User_goods order) {
        service.addOrder(order);
        //取出用户的id
        Integer userid = order.getUserid();
        //提交的时候把用户的id也传过去.
        return "redirect:goodList?userid=" + userid;
    }

    /**
     * 用户角色：查看订单列表功能
     * 我这里是在用户提交订单的时候然后跳转到列表,那么就要把用户的id也传过去
     */
    @RequestMapping("goodList")
    public String goodList(@RequestParam("userid") String userid, HttpServletRequest request) {
        //如何拿到用户的id呢?
        List<User_goods> user_goodsList = service.GoodsList(userid);
        request.setAttribute("list", user_goodsList);
        return "goodList";
    }

    /**
     * 快递员角色：选择一个点单，点击“完成配送”按钮，使该订单状态修改为：已完成
     */
    @RequestMapping("updateGoods")
    public String updateGoods(@RequestParam("userid") String userid, @RequestParam("gid") String gid) {
        service.updateGoods(userid, gid);
        return "redirect:GoodsAll";
    }


}
