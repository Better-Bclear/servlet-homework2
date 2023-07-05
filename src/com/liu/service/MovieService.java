package com.liu.service;

import com.liu.entity.Movie;

import java.util.List;

public interface MovieService {
    //查询所有 展示页面
    public List<Movie> queryAll();
    //插入电影
    public void insertMovie(Movie m);
}
