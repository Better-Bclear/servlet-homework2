package com.liu.test;

import com.liu.dao.MovieDao;
import com.liu.dao.MovieDaoImpl;
import com.liu.entity.Movie;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class MovieDaoImplTest {

    @Test
    public void TestqueryAll(){
        MovieDao md = new MovieDaoImpl();
        List<Movie> list = md.queryAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    @Test
    public void TestinsertMovie(){
        MovieDao md = new MovieDaoImpl();
        Movie m = new Movie();
        m.setMovie_release_date(new Date());
        md.insertMovie(m);
    }
}
