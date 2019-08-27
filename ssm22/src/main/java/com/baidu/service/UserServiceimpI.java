package com.baidu.service;

import com.baidu.entity.User;
import com.baidu.entity.User_goods;
import com.baidu.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpI implements IUserService {
    @Autowired
    private IUserMapper mapper;

    @Override
    public User login(User user) {
        return mapper.login(user);
    }

    @Override
    public List<User_goods> selectGoods() {
        return mapper.selectGoods();
    }

    @Override
    public void addOrder(User_goods order) {
        mapper.addOrder(order);
    }

    @Override
    public List<User_goods> GoodsList(String userid) {
        return mapper.GoodsList(userid);
    }

    @Override
    public List<User_goods> GoodsAll() {
        return mapper.GoodsAll();
    }

    @Override
    public void updateGoods(String userid, String gid) {
        mapper.updateGoods(userid, gid);
    }
}
