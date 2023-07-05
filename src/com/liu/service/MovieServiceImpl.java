package com.liu.service;

import com.liu.dao.MovieDao;
import com.liu.dao.MovieDaoImpl;
import com.liu.entity.Movie;
import com.liu.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    @Override
    public List<Movie> queryAll() {
        Connection conn = null;
        MovieDao md = new MovieDaoImpl();
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<Movie> list = md.queryAll();
            conn.commit();
            if(list != null){
                return list;
            }else{
                return null;
            }
        }catch(Exception e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtil.Close(null,null,conn);
        }
    }

    @Override
    public void insertMovie(Movie m) {
        Connection conn = null;
        MovieDao md = new MovieDaoImpl();
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            md.insertMovie(m);
            conn.commit();

        }catch(Exception e){
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }finally {
            JDBCUtil.Close(null,null,conn);
        }

    }
}
