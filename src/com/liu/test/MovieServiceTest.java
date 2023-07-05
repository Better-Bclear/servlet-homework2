package com.liu.test;

import com.liu.entity.Movie;
import com.liu.service.MovieService;
import com.liu.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MovieServiceTest {
    @Test
    public void queryAll(){
        MovieService ms = new MovieServiceImpl();
        List<Movie> list = ms.queryAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void insertMovie(){
        MovieService ms = new MovieServiceImpl();
        Movie m = new Movie();
        ms.insertMovie(m);
    }
}
