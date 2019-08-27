package com.baidu.ssm45.service;
import com.baidu.ssm45.mapper.UserMapper;
import com.baidu.ssm45.pojo.Good;
import com.baidu.ssm45.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceimpI implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登录
     */
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    /**
     * 列表
     */
    @Override
    public PageInfo ListGood(String mohu, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Good> goodList = userMapper.ListGood(mohu);
        PageInfo<Good> pageInfo = new PageInfo<>(goodList);
        return pageInfo;
    }

    /**
     * 批量删除
     *
     * @param split
     */
    @Override
    public void plsc(String[] split) {
        for (String s : split) {
            userMapper.plsc(s);
        }
    }

    /**
     * 添加1
     */
    @Override
    public List<Good> add1() throws IOException {
        //获取json对象
        ObjectMapper objectMapper = new ObjectMapper();
        //获取redis对象
        String bound = (String) redisTemplate.boundValueOps("bound").get();
        if (bound == null) {
            List<Good> add1 = userMapper.add1();
            String json = objectMapper.writeValueAsString(add1);
            redisTemplate.boundValueOps("bound").set(json);
            return add1;
        } else {
            List list = objectMapper.readValue(bound, List.class);
            return list;
        }
    }


    @Override
    public List<Good> add2(Integer cid) throws Exception {
        //获取json对象
        ObjectMapper object = new ObjectMapper();
        //获取redis对象
        String bo = (String) redisTemplate.boundValueOps("cid").get();
        if (bo == null) {
            List<Good> add2 = userMapper.add2(cid);
            String json = object.writeValueAsString(add2);
            redisTemplate.boundValueOps("cid").set(json);
            return add2;
        } else {
            List list = object.readValue(bo, List.class);
            return list;
        }


    }

    @Override
    public void insert(Good good) {
        userMapper.insert(good);
    }
}
