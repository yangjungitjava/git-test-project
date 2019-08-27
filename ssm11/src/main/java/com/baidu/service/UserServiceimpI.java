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
    public List<User> stuAllList(User user) {
        return mapper.stuAllList(user);
    }

    @Override
    public List<User> otherstu(User user) {
        return mapper.otherstu(user);
    }

    @Override
    public void delstu(Clazz clazz) {
        mapper.delstu(clazz);
    }

    @Override
    public List<Clazz> notchoose(User user) {
        return mapper.notchoose(user);
    }
}
