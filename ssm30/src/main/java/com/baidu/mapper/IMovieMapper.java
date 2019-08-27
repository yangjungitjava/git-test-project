package com.baidu.mapper;

import com.baidu.entity.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface IMovieMapper {
    /**
     * 列表
     */
    @Select("SELECT m.*,GROUP_CONCAT(t.tname)type from a_movie m left join movie_type mt\n" +
            "on m.id=mt.mid left join a_type t on t.tid=mt.tid\n" +
            "group by mt.mid")
    List<Movie> selectMovie();
    /**
     * 列表页面中，点击电影名称，跳转到电影详情页面（5分）
     */
    @Select("SELECT m.*,GROUP_CONCAT(t.tname)type from a_movie m left join movie_type mt\n" +
            "on m.id=mt.mid left join a_type t on t.tid=mt.tid\n" +
            "group by mt.mid having id=#{id}")
    Movie selectMovieById(@Param("id") Integer id);
    /**
     * 电影详情页面中，点击好评加1分，点击差评减1分，之后返回电影列表页面（10分）
     */
    @Update("UPDATE a_movie set score= score + #{tid} where id=#{id}")
    void level(Movie movie);
    /**
     * 删除电影功能（10分）
     */
    @Delete("delete from a_movie where id=#{id}")
    void delMovie(@Param("id") Integer id);
    /**
     * 	添加电影(不包括类型)
     */
    @Insert("INSERT into a_movie SET name=#{name},author=#{author},score=0,discrete=#{discrete}")
    void insertMovie(Movie movie);
    /**
     * 查询电影的类型,电影类型用复选框实现.
     */
    @Select("select * from a_type")
    List<Movie> selectType();
    /**
     * 添加电影的类型,需要向中间表里添加tid和mid
     */
    @Insert("insert into movie_type set mid=#{m.id},tid=#{i}")//这个地方的id就是mid只是我的实体类里面没写mid所以才用的id但是其实id就是mid哈
    void insertType(@Param("m") Movie m,@Param("i") int i);
    /**
     * 查询电影列表(为了获得电影列表里面的mid属性)这里查询的其实是我添加的那条数据它是唯一的.
     */
    @Select("select * from a_movie where name=#{name}and author=#{author} and discrete=#{discrete}")
    Movie MovieList(Movie movie);



























}
