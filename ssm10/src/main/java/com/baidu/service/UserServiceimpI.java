package com.baidu.service;

import com.baidu.entity.Clazz;
import com.baidu.entity.User;
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
    public List<User> stuList(User user) {
        return mapper.stuList(user);
    }

    @Override
    public void delstu(Clazz clazz) {
        mapper.delstu(clazz);
    }

    @Override
    public List<Clazz> addClazz(User user) {
        return mapper.addClazz(user);
    }

    @Override
    public void addclazz(Clazz clazz, User user) {
        mapper.addclazz(clazz, user);
    }

    @Override
    public List<User> AllPassApply(User user) {
        return mapper.AllPassApply(user);
    }

    @Override
    public List<User> stuAll(User user) {
        return mapper.stuAll(user);
    }

    @Override
    public void checkClazz(User user) {
        mapper.checkClazz(user);
    }


}
