package com.baidu.service;

import com.baidu.entity.Computer;
import com.baidu.mapper.IComputerMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ComputerServiceimpI implements IComputerService {
    @Autowired
    private IComputerMapper mapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Computer> selectlist(String name) {
        return mapper.selectlist(name);
    }

    /**
     * 一级节点,先查询redis,redis里面没有酒查询mysql,然后再将mysql查到的 存入redis.
     *
     * @return
     */
    @Override
    public List<Computer> selectOne() throws IOException {
        //创建json形式的对象
        ObjectMapper objectMapper = new ObjectMapper();
        //查询redis
        String boud = (String) redisTemplate.boundValueOps("boud").get();
        //判断是否为空,如果为空那么就先查询mysql,然后再将mysql查到的 存入redis.
        //如果不为空,那么直接查询redis.
        if (boud == null) {
            //查询mysql
            List<Computer> list = mapper.selectOne();
            //转换为json形式
            String value = objectMapper.writeValueAsString(list);
            //存入redis
            redisTemplate.boundValueOps("boud").set(value);
            return list;
        } else {
            //redis中有
            //转换为list集合并返回
            List list = objectMapper.readValue(boud, List.class);
            return list;
        }
    }

    @Override
    public List<Computer> selectTwo(Integer oid) throws IOException {
        //创建json形式的对象
        ObjectMapper objectMapper = new ObjectMapper();
        //查询redis
        String child = (String) redisTemplate.boundValueOps(oid).get();
        //判断是否为空,如果为空那么就先查询mysql,然后再将mysql查到的 存入redis.
        //如果不为空,那么直接查询redis.
        if (child == null) {
            //查询mysql
            List<Computer> list = mapper.selectTwo(oid);
            //转换为json形式
            String value = objectMapper.writeValueAsString(list);
            //存入redis
            redisTemplate.boundValueOps(oid).set(value);
            return list;
        } else {
            //redis中有
            //转换为list集合并返回
            List list = objectMapper.readValue(child, List.class);
            return list;
        }
    }


    @Override
    public Computer selectListById(Computer computer) {
        return mapper.selectListById(computer);
    }

    @Override
    public void editorCom(Computer computer) {
        if (computer.getId() == null) {
            //执行添加
            mapper.addCom(computer);
        } else {
            //执行修改
            mapper.updateCom(computer);
        }
    }

    @Override
    public Computer login(Computer computer) {
        return mapper.login(computer);
    }
}
