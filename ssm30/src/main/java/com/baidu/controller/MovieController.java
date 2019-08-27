package com.baidu.controller;

import com.baidu.entity.Movie;
import com.baidu.service.IMovieService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MovieController {
    @Autowired
    private IMovieService service;
    /**
     * 列表
     */
    @RequestMapping("list")
    public String list(Map<String,Object> map){
        List<Movie> movies = service.selectMovie();
        map.put("list",movies);
        return "list";
    }
    /**
     * 电影详情页面
     */
    @RequestMapping("movie")
    public String movie(Map<String,Object> map, @RequestParam("id")Integer id){
        Movie selectMovieById = service.selectMovieById(id);
        map.put("m",selectMovieById);
        return "movie";
    }
    /**
     * 电影详情页面中，点击好评加1分，点击差评减1分，之后返回电影列表页面（10分）
     */
    @RequestMapping("level")
    public String level(Movie movie,@RequestParam("level")String level){
        service.level(movie,level);
        return "redirect:list";
    }
    /**
     * 删除电影功能（10分）
     */
    @RequestMapping("delMovie")
    public String delMovie(@RequestParam("id")Integer id){
        service.delMovie(id);
        return "redirect:list";
    }
    /**
     *	查询电影的类型,电影类型用复选框实现.
     */
    @RequestMapping("insertMovie")
    public String insertMovie(Movie movie,Map<String,Object> map){
        List<Movie> movies = service.selectType();
        map.put("list",movies);
        return "add";
    }
    /**
     * 添加电影
     * 1.添加电影信息到a_movie
     * 2.获得自增的id电影的id
     * 3.添加类型信息到movie_type
     */
    @RequestMapping("addmoive")
    public String addmoive(@Param("arr")int[] arr, Movie movie){
        service.insertMovie(movie);
        Movie m = service.MovieList(movie);
        service.insertType(m,arr);
        return "redirect:list";
    }




































































}
