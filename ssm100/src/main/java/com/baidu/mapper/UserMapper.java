package com.baidu.mapper;
import com.baidu.pojo.User;
import org.apache.ibatis.annotations.*;



@Mapper
public interface UserMapper {
    @Insert("insert into user set name=#{name},pwd=#{pwd}")
    void registry(User user);



}
