package com.baidu.service;

import com.baidu.entity.Movie;
import com.baidu.mapper.IMovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceimpI implements IMovieService{
    @Autowired
    private IMovieMapper mapper;
    /**
     * 列表
     */
    @Override
    public List<Movie> selectMovie() {
        return mapper.selectMovie();
    }
    /**
     * 列表页面中，点击电影名称，跳转到电影详情页面（5分）
     */
    @Override
    public Movie selectMovieById(Integer id) {
        return mapper.selectMovieById(id);
    }
    /**
     * 电影详情页面中，点击好评加1分，点击差评减1分，之后返回电影列表页面（10分）
     */
    @Override
    public void level(Movie movie, String level) {
        if(level.equals("good")){
            movie.setTid(1);//给tid重新赋值为1
        }
        if (level.equals("bad")){
            movie.setTid(-1);//给tid重新赋值为-1
        }
        mapper.level(movie);
    }
    /**
     * 删除电影功能（10分）
     */
    @Override
    public void delMovie(Integer id) {
        mapper.delMovie(id);
    }
    /**
     * 查询电影的类型,电影类型用复选框实现.
     */
    @Override
    public List<Movie> selectType() {
        return mapper.selectType();
    }
    /**
     * 	添加电影(不包括类型)
     */
    @Override
    public void insertMovie(Movie movie) {
        mapper.insertMovie(movie);
    }

    /**
     * 添加电影的类型
     * @param m
     * @param arr
     */
    @Override
    public void insertType(Movie m, int[] arr) {
        //yongfor循环给它遍历一下,可以一个一个的添加
        for (int i: arr){
            mapper.insertType(m,i);
        }
    }
    /**
     * 查询电影列表(为了获得电影列表里面的mid属性)
     */
    @Override
    public Movie MovieList(Movie movie) {
        return mapper.MovieList(movie);
    }




}
