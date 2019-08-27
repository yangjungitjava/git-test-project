package com.baidu.service;

import com.baidu.entity.Computer;
import com.baidu.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class UserServiceimpI implements UserService{
    @Autowired
    private UserMapper mapper;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 列表和模糊查询
     */
    @Override
    public PageInfo selectCom(String mohu,Integer page,Integer size) {
        //获得当前页和分页单位
        PageHelper.startPage(page,size);
        //调用mapper层的列表和模糊的方法
        List<Computer> computerList = mapper.selectCom(mohu);
        //创建分页插件对象,并且将列表模糊传进去
        PageInfo<Computer> objectPageInfo = new PageInfo<>(computerList);//(computerList)传入了computerList
        return  objectPageInfo;
    }
    /**
     * 查询一级标题
     */
    @Override
    public List<Computer> selectOne() throws IOException {
        //获取json对象
        ObjectMapper objectMapper = new ObjectMapper();
        //获取redis
        String bound = (String) redisTemplate.boundValueOps("bound").get();
        //如果redis里面的值为空那么就先查询mysql,然后把查询出来的值存入Redis.如果有那么直接查询redis,并返回一个集合.
        if(bound==null){
            System.out.print("查询了mysql");
            //查询集合
            List<Computer> selectOne = mapper.selectOne();
            //将集合转换成json形式
           String json= objectMapper.writeValueAsString(selectOne);
           //存入redis
            redisTemplate.boundValueOps("bound").set(json);
            return selectOne;
        }else{
            System.out.print("查询了redis");
            //转换成json形式的list集合并返回
            List list = objectMapper.readValue(bound, List.class);
            return list;
        }
    }
    /**
     * 查询二级标题
     */
    @Override
    public List<Computer> selectTwo(Integer oid) throws IOException {
        //获取json对象
        ObjectMapper objectMapper = new ObjectMapper();
        //获取redis
        String oid1 = (String) redisTemplate.boundValueOps("oid").get();
        if(oid1==null){
            //获取二级标题的集合
            List<Computer> selectTwo = mapper.selectTwo(oid);
            //转换成json形式
            String oid2 = objectMapper.writeValueAsString(selectTwo);
            //存入redis
            redisTemplate.boundValueOps(oid).set(oid2);
            return selectTwo;
        }else{
            //redis中有,转换成json形式的list集合
            List list = objectMapper.readValue(oid1,List.class);
            return list;
        }


    }

    /**
     * 修改或者添加
     */
    @Override
    public void editorComputer(Computer computer) {
        if(computer.getCid()!=null){
            //执行修改
            mapper.updateCom(computer);
        }else{
            //执行添加
            mapper.insertComputer(computer);
        }
    }

    /**
     * 修改回显
     */
    @Override
    public Computer selectCombyId(Integer cid) {
        return mapper.selectCombyId(cid);
    }

    /**
     * 删除
     */
    @Override
    public void delCom(Computer computer) {
        mapper.delCom(computer);
    }
    /**
     * 登录
     */
    @Override
    public Computer login(Computer computer) {
        return mapper.login(computer);
    }
    /**
     * 批量删除
     */
    @Override
    public void plsc(String[] split) {
       for(String ids:split){
           mapper.plsc(ids);
        }
    }


}
