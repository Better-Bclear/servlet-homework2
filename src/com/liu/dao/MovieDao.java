package com.liu.dao;

import com.liu.entity.Movie;

import java.util.List;

public interface MovieDao {
    //查所有 用于封面展示
    public List<Movie> queryAll();
    //添加电影
    public void insertMovie(Movie m);

}
