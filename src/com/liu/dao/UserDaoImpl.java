package com.liu.dao;

import com.liu.entity.User;
import com.liu.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User queryByUserName(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "select user_id,user_name,user_pwd,user_email,user_role from user where user_name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUser_name());
            rs = ps.executeQuery();
            User u = new User();
            while(rs.next()){
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setUser_pwd(rs.getString("user_pwd"));
                u.setUser_email(rs.getString("user_email"));
                u.setUser_role(rs.getInt("user_role"));
            }
            return u;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            JDBCUtil.Close(rs,ps,null);
        }

    }

    @Override
    public void insert(User u) {
        Connection conn = null;
        PreparedStatement ps= null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "insert into user(user_name,user_pwd,user_email) value (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,u.getUser_name());
            ps.setString(2,u.getUser_pwd());
            ps.setString(3,u.getUser_email());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            {
                JDBCUtil.Close(null,ps,null);
            }
        }
    }

    @Override
    public List<User> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "select user_id,user_name,user_email from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while(rs.next()){
                User u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setUser_email(rs.getString("user_email"));
                list.add(u);
            }
            return list;
        }catch(Exception e){
            throw new RuntimeException("查询所有失败");
        }finally {
            JDBCUtil.Close(rs,ps,null);
        }
    }

    @Override
    public List<User> queryAll(int a, int b) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "select user_id,user_name,user_email from user limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(a-1)*b);
            ps.setInt(2,b);
            rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while(rs.next()){
                User u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_name(rs.getString("user_name"));
                u.setUser_email(rs.getString("user_email"));
                list.add(u);
            }
            return list;
        }catch(Exception e){
            throw new RuntimeException("查询所有失败");
        }finally {
            JDBCUtil.Close(rs,ps,null);
        }
    }

    @Override
    public void deleteById(int id) {
        Connection conn =null;
        PreparedStatement ps = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "delete from user where user_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(null,ps,null);
        }
    }

    @Override
    public User queryById(int id) {
        Connection conn = null;
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "select user_name,user_pwd,user_email from user where user_id=?";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            User u = new User();
            while(rs.next()){
                u.setUser_name(rs.getString("user_name"));
                u.setUser_pwd(rs.getString("user_pwd"));
                u.setUser_email(rs.getString("user_email"));
            }
            return u;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtil.Close(rs,ps,null);
        }
    }

    @Override
    public List<User> queryByUserName(String str) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtil.getConnection();
            String sql = "select user_id,user_name,user_email from user where user_name like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,("%"+str+"%"));
            rs = ps.executeQuery();
            List<User> list = new ArrayList<>();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_email(rs.getString("user_email"));
                System.out.println(user);
                list.add(user);
            }
            System.out.println(list);
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtil.Close(rs,ps,null);
        }
    }
}
