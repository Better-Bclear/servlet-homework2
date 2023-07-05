package com.liu.dao;

import com.liu.entity.Movie;
import com.liu.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao{
    @Override
    public List<Movie> queryAll() {
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "select movie_id,movie_cn_name,movie_fg_name,movie_actor,movie_director,movie_detail,movie_duration,movie_type,movie_score,movie_box_office,movie_comment_count,movie_release_date,movie_picture,movie_country,movie_state from movie";
            ps= conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Movie> list = new ArrayList<>();
            while(rs.next()){
                Movie m = new Movie();
                m.setMovie_id(rs.getInt("movie_id"));
                m.setMovie_cn_name(rs.getString("movie_cn_name"));
                m.setMovie_score(rs.getDouble("movie_score"));
                m.setMovie_picture(rs.getString("movie_picture"));
                list.add(m);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtil.Close(rs,ps,null);
        }
    }

    @Override
    public void insertMovie(Movie m) {
        Connection conn =null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "insert into movie(movie_cn_name,movie_fg_name,movie_director,movie_duration,movie_type,movie_release_date,movie_country,movie_picture,movie_actor,movie_detail) values(?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,m.getMovie_cn_name());
            ps.setString(2, m.getMovie_fg_name());
            ps.setString(3,m.getMovie_director());
            ps.setString(4,m.getMovie_duration());
            ps.setString(5,m.getMovie_type());
            java.sql.Date sqlDate = new java.sql.Date(m.getMovie_release_date().getTime());
            ps.setDate(6,sqlDate);
            ps.setString(7,m.getMovie_country());
            ps.setString(8,m.getMovie_picture());
            ps.setString(9,m.getMovie_actor());
            ps.setString(10,m.getMovie_detail());
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(null,ps,null);
        }
    }
}
