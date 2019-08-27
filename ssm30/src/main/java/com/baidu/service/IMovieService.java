package com.baidu.service;

import com.baidu.entity.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IMovieService {
    /**
     * 列表
     */
    List<Movie> selectMovie();
    /**
     * 列表页面中，点击电影名称，跳转到电影详情页面（5分）
     */
    Movie selectMovieById(Integer id);
    /**
     * 电影详情页面中，点击好评加1分，点击差评减1分，之后返回电影列表页面（10分）
     */
    void level(Movie movie,String level);
    /**
     * 删除电影功能（10分）
     */
    void delMovie(Integer id);
    /**
     * 查询电影的类型,电影类型用复选框实现.
     */
    List<Movie> selectType();
    /**
     * 	添加电影(不包括类型)
     */
    void insertMovie(Movie movie);
    /**
     * 添加电影的类型,需要向中间表里添加tid和mid,这里的int[] arr表示的是int类型的叫arr的数组,也是所有的tid就是电影类型.
     */
    void insertType( Movie m, int[] arr);
    /**
     * 查询电影列表(为了获得电影列表里面的mid属性)
     */
    Movie MovieList(Movie movie);































































}
