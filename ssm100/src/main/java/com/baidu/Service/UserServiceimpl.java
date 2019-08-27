package com.baidu.Service;
import com.baidu.mapper.UserMapper;
import com.baidu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private UserMapper mapper;

    @Override
    public void registry(User user) {
        mapper.registry(user);
    }
}
