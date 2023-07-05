package com.liu.service;

import com.liu.dao.UserDao;
import com.liu.dao.UserDaoImpl;
import com.liu.entity.User;
import com.liu.util.JDBCUtil;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Override
    //登录方法
    public String login(User u) {
        Connection conn = null;
        UserDao ud = new UserDaoImpl();
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            User user = ud.queryByUserName(u);
            conn.commit();
            if(user.getUser_role()==1&&user.getUser_name().equals("admin")&&user.getUser_pwd().equals("123456")){
                return "管理账户登录成功";
            }else if(user.getUser_role()==0&&user.getUser_name().equals(u.getUser_name())&&user.getUser_pwd().equals(u.getUser_pwd())){
                return "普通用户登录成功";
            }else{
                return "登录失败，请检查账号密码是否正确";
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            JDBCUtil.Close(null,null,conn);
        }
    }

    @Override
    public String regUser(User u) {
        Connection conn = null;
        UserDao ud = new UserDaoImpl();
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            ud.insert(u);
            conn.commit();

            return "注册成功";


        } catch (Exception e) {
            e.printStackTrace();
            return "注册失败";
        } finally {
            JDBCUtil.Close(null, null, conn);
        }
    }

    @Override
    public List<User> queryAll() {
        Connection conn = null;
        UserDao ud = new UserDaoImpl();
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<User> list = ud.queryAll();
            conn.commit();
            return list;
        }catch(Exception e){
            throw new RuntimeException("查询所有，返回集合失败");
        }finally {
            JDBCUtil.Close(null,null,conn);
        }
    }

    @Override
    public Map<String,Object> queryAll(int a, int b) {
        Connection conn = null;
        UserDao ud = new UserDaoImpl();
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<User> users = ud.queryAll();
            List<User> list = ud.queryAll(a,b);
            conn.commit();
            Map<String,Object> map = new HashMap<>();
            if((users.size()%b)==0){
                map.put("pages",(users.size()/b));
                 map.put("page",list);
                return map ;
            }else{
                map.put("pages",(users.size()/b)+1);
                map.put("page",list);
                return map ;
            }
        }catch(Exception e){
            throw new RuntimeException("分页查询，返回集合失败");
        }finally {
            JDBCUtil.Close(null,null,conn);
        }
    }

    @Override
    public String deleteById(int id) {
        Connection conn = null;
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            UserDao ud= new UserDaoImpl();
            ud.deleteById(id);
            conn.commit();
            return "删除成功";
        }catch(Exception e){
            e.printStackTrace();
            return "删除失败";
        }finally {
            JDBCUtil.Close(null,null,conn);
        }
    }

    @Override
    public User queryById(int id) {
        Connection conn = JDBCUtil.getConnection();
        UserDao ud= new UserDaoImpl();
        try{
            conn.setAutoCommit(false);
            User user = ud.queryById(id);
            conn.commit();
            return user;

        }catch(Exception e){
            throw new RuntimeException("根据id查询失败");
        }finally {
            JDBCUtil.Close(null,null,conn);
        }
    }

    @Override
    public List<User> queryByUsername(String str) {
        Connection conn = null;
        UserDao ud = new UserDaoImpl();
        try{
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            List<User> list = ud.queryByUserName(str);
            conn.commit();
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            JDBCUtil.Close(null,null,conn);
        }
    }
}
